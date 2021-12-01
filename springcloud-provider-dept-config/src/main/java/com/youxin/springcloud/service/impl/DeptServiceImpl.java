package com.youxin.springcloud.service.impl;

import com.youxin.springcloud.mapper.DeptMapper;
import com.youxin.springcloud.pojo.Dept;
import com.youxin.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youxin
 * @program springcloud
 * @description DeptServiceImpl
 * @date 2021-11-08 18:52
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public Dept queryById(Long dept_no) {
        return deptMapper.queryById(dept_no);
    }

    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
