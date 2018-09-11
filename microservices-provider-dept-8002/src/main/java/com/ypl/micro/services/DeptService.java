package com.ypl.micro.services;

import com.zy.micro.entity.Dept;

import java.util.List;

public interface DeptService {

    Dept selectByPrimaryKey(Integer id) throws Exception;

    int insertSelective(Dept record) throws Exception;

    int deleteByPrimaryKey(Integer id) throws Exception;

    int updateByPrimaryKey(Dept record) throws Exception;

    List<Dept> findAll() throws Exception;
}
