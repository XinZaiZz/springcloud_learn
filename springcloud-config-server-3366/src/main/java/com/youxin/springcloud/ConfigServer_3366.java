package com.youxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-13 18:39
 */
@SpringBootApplication
@EnableConfigServer// 开启spring cloud config server服务
public class ConfigServer_3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_3366.class, args);
    }
}
