package com.wyq.study.dubbo.runtime;

import com.wyq.study.dubbo.facade.User;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 王艳群
 * @description ReporterApplicationContextInitializer
 * @date 2020/10/11
 */
public class ReporterApplicationContextInitializer implements ApplicationContextInitializer {

    private User user;

    public ReporterApplicationContextInitializer(User user) {
        this.user = user;
    }

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        configurableApplicationContext.addBeanFactoryPostProcessor(new AgentBeanFactoryConfigurer(user));
    }
}
