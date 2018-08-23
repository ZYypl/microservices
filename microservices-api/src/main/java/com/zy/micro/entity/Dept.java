package com.zy.micro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Vendorypl on 2018/8/23.
 */
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
@Data//get,set
@Accessors(chain = true)//链式调用

public class Dept implements Serializable{

    private Long depId;
    private String depName;
    private String db_source;

}
