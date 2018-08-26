package com.ypl.micro.services.impl;

import com.ypl.micro.dao.DeptMapper;
import com.ypl.micro.services.DeptService;
import com.zy.micro.entity.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    DeptMapper deptMapper;


    @Override
    public Dept selectByPrimaryKey(Integer id) throws Exception {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Dept record) throws Exception {
        return deptMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        return deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Dept record) throws Exception {
        return deptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Dept> findAll() throws Exception {
        return deptMapper.findAll();
    }
}
