package com.zy.micro.service;


//import com.zy.micro.common.ApiResult;
import com.zy.micro.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(value = "MICROSERVICES-DEPT")
public interface DeptClientService {
    @RequestMapping(value = "/dept/select/{id}",method = RequestMethod.GET)
    Dept get(@PathVariable("id") Integer depno);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> list();

}
