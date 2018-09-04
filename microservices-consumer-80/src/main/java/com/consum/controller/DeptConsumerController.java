package com.consum.controller;


import com.zy.micro.common.ApiResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class DeptConsumerController {

    @Resource
    RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8001";

    private static final String REST_URL_PREFIX = "http://MICROSERVICES-DEPT";
    //真正的通过微服务名字去eureka查找并访问

    @RequestMapping(value = "/consumer/get/{id}",method = RequestMethod.GET)
    public ApiResult get(@PathVariable("id") Integer depno){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/select/"+depno,ApiResult.class);
    }

}
