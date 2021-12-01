package com.youxin.springcloud.service;

import com.youxin.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author youxin
 * @program springcloud
 * @description Hystrix服务降级
 * @date 2021-11-12 18:25
 */
@Component
public class DeptClientFallbackService implements FallbackFactory {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public boolean addDept(Dept dept) {
                return false;
            }

            public List<Dept> queryAll() {
                return null;
            }

            public Dept queryById(Long dept_no) {
                return new Dept()
                        .setDept_no(dept_no)
                        .setDept_name("id=>" + dept_no + ",由于客户端提供了服务降级，所以现服务已被关闭")
                        .setDb_source("no data searched!");
            }
        };
    }
}
