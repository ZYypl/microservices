package com.consum.config;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //通过RestTemplate访问restful接口
    @Bean
    @LoadBalanced //ribbon负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule(){
//        //return new RoundRobinRule(); 默认:轮循
//        return new RandomRule();  //  随机
//    }
}

