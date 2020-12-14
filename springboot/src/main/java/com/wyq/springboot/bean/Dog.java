package com.wyq.springboot.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description Dog
 * @date 2020/9/28
 */
@Component
public class Dog implements BeanNameAware, InitializingBean {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        System.out.println("设置beanName");
        this.beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
            "name='" + name + '\'' +
            '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("dog afterPropertiesSet");
    }
}
