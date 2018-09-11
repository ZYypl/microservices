package com.ribbon;

import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myrule {

    //针对某一微服务自定义ribbon
    @Bean
    public IRule myRule(){
//        return new RandomRule();   //自定义ribbon给定的
        //return  new RetryRule();

        return new Ribbon_MY();      //自己写的
    }

}
