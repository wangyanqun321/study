package com.wyq.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description BeanPostProcessorImpl
 * @date 2020/10/7
 */
@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("dog".equals(beanName)) {
            System.out.println("dog 初始化方法执行之前");
            System.out.println(bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("dog".equals(beanName)) {
            System.out.println("dog 初始化方法执行之后");
        }
        return bean;
    }
}
