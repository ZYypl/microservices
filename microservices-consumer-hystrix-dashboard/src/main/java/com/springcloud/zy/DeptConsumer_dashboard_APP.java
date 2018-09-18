package com.springcloud.zy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_dashboard_APP {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(DeptProvider_APP.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        AppCtx.ctx = app.run(args);

        SpringApplication.run(DeptConsumer_dashboard_APP.class, args);
    }
}
