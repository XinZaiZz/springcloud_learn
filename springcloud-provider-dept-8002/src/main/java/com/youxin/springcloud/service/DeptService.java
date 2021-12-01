package com.youxin.springcloud.service;

import com.youxin.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryById(Long dept_no);

    public List<Dept> queryAll();
}
