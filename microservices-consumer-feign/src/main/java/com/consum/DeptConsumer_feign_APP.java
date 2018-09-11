package com.consum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan("com.zy.micro")
public class DeptConsumer_feign_APP {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(DeptProvider_APP.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        AppCtx.ctx = app.run(args);

        SpringApplication.run(DeptConsumer_feign_APP.class, args);
    }
}
