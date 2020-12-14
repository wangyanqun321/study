package com.wyq.study.dubbo.runtime;

import com.wyq.study.dubbo.facade.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author 王艳群
 * @description AgentBeanFactoryConfigurer
 * @date 2020/10/11
 */
public class AgentBeanFactoryConfigurer implements BeanFactoryPostProcessor {

    private User user;

    public AgentBeanFactoryConfigurer(User user) {
        this.user = user;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) configurableListableBeanFactory;
        registry.registerBeanDefinition("user", new RootBeanDefinition(User.class));
        registry.registerBeanDefinition("agentRuntime", new RootBeanDefinition(AgentRuntime.class));
        configurableListableBeanFactory.registerSingleton("user", user);
        configurableListableBeanFactory.registerResolvableDependency(User.class, user);
    }
}
