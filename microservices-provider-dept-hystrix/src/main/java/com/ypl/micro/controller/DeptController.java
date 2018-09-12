package com.ypl.micro.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ypl.micro.services.DeptService;
import com.zy.micro.common.ApiResult;
import com.zy.micro.entity.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {

    @Resource
    DeptService deptServiceImpl;

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/dept/insert",method = RequestMethod.POST)
    public ApiResult insert(Dept dept) {
        ApiResult apiResult = new ApiResult();

        try {
            deptServiceImpl.insertSelective(dept);
        } catch (Exception e) {
            logger.error("error: ", e);
            apiResult.setResult(true);
            apiResult.setMessage("异常");
            return apiResult;
        }
        apiResult.setResult(true);
        apiResult.setMessage("新增成功");
        return apiResult;
    }
    @RequestMapping(value = "/dept/select/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hystrix_get")
    public ApiResult get(@PathVariable("id") Integer dept) {
        ApiResult apiResult = new ApiResult();
        Dept dept1;
//        try {
             dept1 = deptServiceImpl.selectByPrimaryKey(dept);
             if(null==dept1){
                 throw new RuntimeException("ID:"+dept+"无对象");
             }
//        } catch (Exception e) {
//            logger.error("error: ", e);
//            apiResult.setResult(true);
//            apiResult.setMessage("异常");
//            return apiResult;
//        }
        apiResult.setResult(true);
        apiResult.setData(dept1);
        apiResult.setMessage("查询成功");
        return apiResult;
    }

    public ApiResult hystrix_get(@PathVariable("id") Integer dept){
        ApiResult apiResult = new ApiResult();
        apiResult.setResult(false);
        apiResult.setMessage("查询:"+dept+"无数据对象");
        return apiResult;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public ApiResult list() {
        ApiResult apiResult = new ApiResult();
       List<Dept> dept1;
        try {
            dept1 = deptServiceImpl.findAll();
        } catch (Exception e) {
            logger.error("error: ", e);
            apiResult.setResult(true);
            apiResult.setMessage("异常");
            return apiResult;
        }
        apiResult.setResult(true);
        apiResult.setData(dept1);
        apiResult.setMessage("查询成功");
        return apiResult;
    }


}
