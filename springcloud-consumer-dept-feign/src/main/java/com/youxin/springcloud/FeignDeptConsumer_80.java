package com.youxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-09 16:13
 */
@SpringBootApplication
@EnableEurekaClient //开启eureka客户端
// feign客户端注解,并指定要扫描的包以及配置接口DeptClientService
@EnableFeignClients(basePackages = {"com.youxin.springcloud.service"})
// 切记不要加这个注解，不然会出现404访问不到
//@ComponentScan("com.youxin.springcloud")
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class, args);
    }
}
