package com.my.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  //zuul
public class Zuul_9527_APP {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(DeptProvider8001_hystrix_APP.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        AppCtx.ctx = app.run(args);

        SpringApplication.run(Zuul_9527_APP.class, args);
    }
}
