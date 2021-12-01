package com.youxin.springcloud.controller;

import com.youxin.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-09 15:51
 */
@RestController
public class DeptConsumerController {

    //消费者，不应该有服务层
    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的Restful服务模板

//    public static final String URL_PREFIX = "http://localhost:8001/dept";
    //ribbon: 这里的地址应该是一个变量，通过服务名来访问，即SPRINGCLOUD-PROVIDER-DEPT
    public static final String URL_PREFIX = "http://springcloud-provider-dept/dept";

    //url : http://localhost:8001/dept/find/1
    @GetMapping("/consumer/dept/get/{id}")
    public Dept findById(@PathVariable("id") Long dept_no) {
        return restTemplate.getForObject(URL_PREFIX + "/find/" + dept_no, Dept.class);
    }

    @GetMapping("/consumer/dept/getAll")
    public List<Dept> getAll() {
        return restTemplate.getForObject(URL_PREFIX + "/findAll", List.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return restTemplate.postForObject(URL_PREFIX + "/add", dept, Boolean.class);
    }

}
