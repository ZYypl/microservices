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

    private Long depno;
    private String depname;
    private String db_source;

    public Long getDepno() {
        return depno;
    }

    public void setDepno(Long depno) {
        this.depno = depno;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }
}
