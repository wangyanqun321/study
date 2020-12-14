package com.wyq.springboot.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description MyFactoryBean
 * @date 2020/9/28
 */
@Component("(abc")
public class MyFactoryBean implements FactoryBean<People> {

    private Dog dog;

    public MyFactoryBean(Dog dog) {
        this.dog = dog;
    }

    @Override
    public People getObject() throws Exception {
        System.out.println(dog);
        return new People(dog);
    }

    @Override
    public Class<?> getObjectType() {
        return People.class;
    }
}
