package com.youxin.springcloud.controller;

import com.youxin.springcloud.pojo.Dept;
import com.youxin.springcloud.service.DeptClientService;
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



    @Autowired
    private DeptClientService deptClientService;

    //url : http://localhost:8001/dept/find/1
    @GetMapping("/consumer/dept/get/{id}")
    public Dept findById(@PathVariable("id") Long dept_no) {
        return deptClientService.queryById(dept_no);
    }

    @GetMapping("/consumer/dept/getAll")
    public List<Dept> getAll() {
        return deptClientService.queryAll();
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptClientService.addDept(dept);
    }

}
