package com.youxin.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-09 15:52
 */
@Configuration
public class DeptConfig {

    //配置负载均衡实现RestTemplate
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
