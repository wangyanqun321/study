package com.wyq.springboot.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description BeanAwareImpl
 * @date 2020/10/7
 */
@Component
public class BeanAwareImpl implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        System.out.println("设置beanName");
        this.beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }
}
