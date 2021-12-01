package com.youxin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youxin
 * @program springcloud
 * @description
 * @date 2021-11-14 00:57
 */
@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/config")
    public String getConfig() {
        return "applicationName=>" + applicationName + "\n" +
                "eurekaServer=>" + eurekaServer + "\n" +
                "serverPort=>" + serverPort;
    }

}
