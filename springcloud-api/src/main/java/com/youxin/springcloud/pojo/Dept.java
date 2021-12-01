package com.youxin.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author youxin
 * @program springcloud
 * @description 部门实体类
 * @date 2021-11-08 16:30
 */

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法，例如dept.setDept_no(11).setDept_name("组织部")...
public class Dept implements Serializable {//实体类要想远程调用必须序列化

    //主键
    private Long dept_no;
    private String dept_name;

    //这个字段是看该数据存在哪个数据库中，微服务中，一个服务对应一个数据库，相同的信息可能被存在不同的数据库中
    private String db_source;

    public Dept(String dept_name) {
        this.dept_name = dept_name;
    }
}
