package com.wyq.study.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyq.study.dubbo.facade.MyResponse;
import com.wyq.study.dubbo.facade.TestService;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description TestServiceImpl
 * @date 2020/10/22
 */
@Service
@Component
public class TestServiceImpl implements TestService {

    @Override
    public MyResponse test() {
        System.out.println("success");
        return new MyResponse("A", "M");
    }
}
