package com.youxin.springcloud.service;

import com.youxin.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
// @FeignClient:微服务客户端注解,value:指定微服务的名字,这样就可以使Feign客户端直接找到对应的微服务
@FeignClient(value = "springcloud-provider-dept",fallbackFactory = DeptClientFallbackService.class) //fallbackFactory指定降级配置类
public interface DeptClientService {

    //这里的GetMapping要跟服务提供者一样
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);

    @GetMapping("/dept/findAll")
    public List<Dept> queryAll();

    @GetMapping("/dept/find/{id}")
    public Dept queryById(@PathVariable("id") Long dept_no);
}
