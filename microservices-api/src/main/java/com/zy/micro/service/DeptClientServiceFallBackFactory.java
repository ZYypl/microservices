package com.zy.micro.service;

import com.zy.micro.common.ApiResult;
import com.zy.micro.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//服务降级

@Component  //不要忘记加
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Integer depno) {
                Dept d = new Dept();
                d.setDepname("wushuju");
                return d ;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
