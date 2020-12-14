package com.wyq.springboot.bean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description DoByApplicationListener
 * @date 2020/11/16
 */
@Component
public class DoByApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            System.out.println("DoByApplicationListener do something");
        }
    }
}
