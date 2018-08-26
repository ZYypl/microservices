package com.ypl.micro.dao;

import com.zy.micro.entity.Dept;
//import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface DeptMapper {

//    @Delete("delete from dept where depno =#{id}")
    int deleteByPrimaryKey(Integer id);

//    @Insert("insert into dept(depname,db_source) values(#{depname},DATABASE())")
    int insertSelective(Dept record);

//    @Select("select * from dept where depno =#{id}")
    Dept selectByPrimaryKey(Integer id);

//    @Update("update dept set depname =#{depname},db_source=#{db_source}")
    int updateByPrimaryKey(Dept record);

//    @Select("select * from dept")
    List<Dept> findAll();
}
