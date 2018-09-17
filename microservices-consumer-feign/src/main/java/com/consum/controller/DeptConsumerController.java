package com.consum.controller;

import com.zy.micro.common.ApiResult;
import com.zy.micro.entity.Dept;
import com.zy.micro.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
//import javax.annotation.Resource;


@RestController
public class DeptConsumerController {

    //  feign
    // /面向接口
    @Resource
    DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/get/{id}",method = RequestMethod.GET)
    public ApiResult get(@PathVariable("id") Integer depno){
        ApiResult apiResult =new ApiResult();
        apiResult.setResult(true);
        apiResult.setMessage("查询成功");
        apiResult.setData(this.deptClientService.get(depno));
        return apiResult;
//        return this.deptClientService.get(depno);
    }

    @RequestMapping(value = "/consumer/list",method = RequestMethod.GET)
    public ApiResult list(){
        ApiResult apiResult =new ApiResult();
        apiResult.setResult(true);
        apiResult.setMessage("查询成功");
        apiResult.setData(this.deptClientService.list());
        return apiResult;
    }


}
