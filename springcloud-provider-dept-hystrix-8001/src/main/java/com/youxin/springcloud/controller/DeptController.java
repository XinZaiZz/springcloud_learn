package com.youxin.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.youxin.springcloud.pojo.Dept;
import com.youxin.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author youxin
 * @program springcloud
 * @description DeptController
 * @date 2021-11-08 18:53
 */
//提供Restful服务
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @HystrixCommand(fallbackMethod="queryById_hystrix") //如果根据id查询出现异常,则走hystrixGet这段备选代码
    @GetMapping("/dept/find/{id}")
    public Dept queryById(@PathVariable("id") Long dept_no) {
        Dept dept = deptService.queryById(dept_no);
        if (dept == null) {
             throw  new RuntimeException("id=>" + dept_no + "不存在");
        }
        return dept;
    }

    @GetMapping("/dept/findAll")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    //注册进来的微服务，获取一些信息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        //获取微服务列表的清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery=>services:" + services);

        //得到一个具体的微服务信息，通过具体的微服务id:application-name
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId() + "\t" +
                    instance.getMetadata()
                    );
        }
        return discoveryClient;
    }

    /**
     * @author youxin
     * @date 2021-11-12 17:24
     * @param dept_no 根据dept_no查询备用方案（熔断机制）
     * @return com.youxin.springcloud.pojo.Dept
     * @throws
     * @since
     */
    public Dept queryById_hystrix(@PathVariable("id") Long dept_no) {
        return new Dept().setDept_no(dept_no)
                .setDept_name("id=>" + dept_no + ",数据库中没有对应的部门信息！")
                .setDb_source("没有对应数据库");
    }

}
