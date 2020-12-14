package com.wyq.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description BeanFactoryPostProcessorImpl
 * @date 2020/10/7
 */
@Component
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition dog = beanFactory.getBeanDefinition("dog");
        MutablePropertyValues propertyValues = dog.getPropertyValues();
        propertyValues.add("name", "name changed from BeanFactoryPostProcessor ");
        /*Object dog1 = beanFactory.getBean("dog");
        System.out.println("BeanFactoryPostProcessor 获取到dog：" + dog1);*/
    }
}
