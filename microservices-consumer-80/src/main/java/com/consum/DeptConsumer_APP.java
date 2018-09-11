package com.consum;

import com.ribbon.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICES-DEPT",configuration = Myrule.class)//针对某一项微服务自定义负载均衡规则
public class DeptConsumer_APP {//microservices-dept

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(DeptProvider_APP.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        AppCtx.ctx = app.run(args);

        SpringApplication.run(DeptConsumer_APP.class, args);
    }
}
