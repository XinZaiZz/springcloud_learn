package com.youxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-08 18:58
 */
@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到eureka中！
@EnableDiscoveryClient //注册服务发现
public class DeptProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }
}
