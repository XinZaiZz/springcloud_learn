package com.youxin.springcloud;

import com.youxin.rule.MyLoadBalanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-09 16:13
 */
@SpringBootApplication
@EnableEurekaClient //开启eureka客户端
// 微服务在启动时就去加载自定义的Ribbon配置类
@RibbonClient(name = "springcloud-provider-dept",configuration = MyLoadBalanceRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
