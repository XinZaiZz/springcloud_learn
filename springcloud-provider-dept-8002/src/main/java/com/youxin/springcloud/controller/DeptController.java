package com.youxin.springcloud.controller;

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

    @GetMapping("/dept/find/{id}")
    public Dept queryById(@PathVariable("id") Long dept_no) {
        return deptService.queryById(dept_no);
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

}
