package com.youxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-10 01:18
 */
@SpringBootApplication
@EnableEurekaServer //服务端的启动类，可以接收别人注册进来
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class, args);
    }
}
