package com.wyq.springboot.bean;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description TestService2
 * @date 2020/7/12
 */
@Component
public class TestService2 {

    @Override
    public String toString() {
        return "TestService2{}";
    }

    @EventListener
    public void listener(String event) {
        System.out.println("监听到事件：" + event);
    }
}
