package com.youxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-13 16:18
 */
@SpringBootApplication
//开启zuul功能
@EnableZuulProxy
public class ZuulGatewayDept_10086 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayDept_10086.class, args);
    }
}
