package com.youxin.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-08 18:58
 */
@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到eureka中！
@EnableDiscoveryClient //注册服务发现
@EnableCircuitBreaker // 添加对熔断的支持注解
public class DeptProviderHystrix_Config_8001_8004 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_Config_8001_8004.class,args);
    }

    //增加一个 Servlet
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream"); //访问该页面就是监控页面
        return servletRegistrationBean;
    }
}
