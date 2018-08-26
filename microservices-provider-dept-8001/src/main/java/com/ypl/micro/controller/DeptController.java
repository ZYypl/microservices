package com.ypl.micro.controller;

import com.ypl.micro.common.ApiResult;
import com.ypl.micro.services.DeptService;
import com.zy.micro.entity.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @RequestMapping(value = "/dept/select",method = RequestMethod.GET)
    public ApiResult get(Integer dept) {
        ApiResult apiResult = new ApiResult();
        Dept dept1;
        try {
             dept1 = deptServiceImpl.selectByPrimaryKey(dept);
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