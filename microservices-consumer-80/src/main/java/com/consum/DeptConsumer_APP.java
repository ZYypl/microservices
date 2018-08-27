package com.consum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeptConsumer_APP {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(DeptProvider_APP.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        AppCtx.ctx = app.run(args);

        SpringApplication.run(DeptConsumer_APP.class, args);
    }
}
