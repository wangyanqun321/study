package com.wyq.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @author 王艳群
 * @description MyBean
 * @date 2020/7/12
 */

//@Component
public class TestService implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware,
    ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, ServletContextAware,
    BeanPostProcessor, InitializingBean, DisposableBean, DestructionAwareBeanPostProcessor, FactoryBean<Cat> {

    private String name;

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    private ResourceLoader resourceLoader;

    private ApplicationEventPublisher applicationEventPublisher;

    private MessageSource messageSource;

    private ApplicationContext applicationContext;

    private ServletContext servletContext;


    public void test() {
        System.out.println("test Service");
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("第一步, setBeanName ：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        System.out.println("第二步, setBeanClassLoader ：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("第三步, setBeanClassLoader ：" + beanFactory);
        System.out.println(beanFactory.getClass().getName());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        System.out.println("第四步, setResourceLoader ：" + resourceLoader);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("第五步, setApplicationEventPublisher ：" + applicationEventPublisher);
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
        System.out.println("第六步, setMessageSource ：" + messageSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("第七步, setApplicationContext ：" + applicationContext);
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        System.out.println("第八步, setServletContext ：" + servletContext);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("第九步, postProcessBeforeInitialization：" + beanName);
        if(bean.getClass().getCanonicalName().equals("com.wyq.springboot.bean.TestService")){
            System.out.println("第九步, postProcessBeforeInitialization：" + beanName);
            System.out.println(bean.getClass());
            System.out.println(bean.getClass().getCanonicalName());
        }
        /*if(beanName.equals("testService2")){
            System.out.println("第九步, postProcessBeforeInitialization：" + beanName);
            System.out.println(bean.getClass());
            System.out.println(bean.getClass().getCanonicalName());
        }*/
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("testService")){
            System.out.println("第十步, postProcessAfterInitialization：" + beanName);
        }
        return bean;
    }

    public void publisherEvent() {
        applicationEventPublisher.publishEvent("test publish event");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第十一步, afterPropertiesSet：");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第十二步bean 被销毁了");
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("第十三步bean 销毁前：" + beanName);
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        System.out.println("第十四步bean bean 的卸载: " + bean.getClass());
        return true;
    }

    @Override
    public Cat getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<Cat> getObjectType() {
        return Cat.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
