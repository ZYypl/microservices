package com.consum.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //通过RestTemplate访问restful接口
    @Bean
    @LoadBalanced //ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

