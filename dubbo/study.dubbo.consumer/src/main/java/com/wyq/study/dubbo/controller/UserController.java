package com.wyq.study.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyq.study.dubbo.facade.MyResponse;
import com.wyq.study.dubbo.facade.TestService;
import com.wyq.study.dubbo.facade.User;
import com.wyq.study.dubbo.facade.UserService;
import com.wyq.study.dubbo.injector.Empty;
import com.wyq.study.dubbo.runtime.AgentRuntime;
import com.wyq.study.dubbo.runtime.ReporterApplicationContextInitializer;
import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王艳群
 * @description UserController
 * @date 2020/10/9
 */
@RestController
@RequestMapping("/user")
public class UserController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Reference
    private UserService userService;

    @Reference
    private TestService testService;

    @GetMapping("/add")
    public boolean testAddUser(int id, String name) {
        userService.addUser(new User(id, name));
        MyResponse test = testService.test();
        System.out.println(test);
        System.out.println("消费方调用完成");
        return true;
    }

    @GetMapping
    public User getUser(int id) {
        return userService.getUser(id);
    }

    @GetMapping("/add/container")
    public boolean testAddUserToContainer(int id, String name) {
        User user = new User(id, name);
        ConfigurableApplicationContext child = buildChildContainer((ConfigurableApplicationContext) applicationContext, user);
        AgentRuntime agentRuntime = child.getBean("agentRuntime", AgentRuntime.class);
        agentRuntime.createUser();
        System.out.println("消费方调用完成");
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private static ConfigurableApplicationContext buildChildContainer(ConfigurableApplicationContext parent, User user) {
        return new SpringApplicationBuilder(Empty.class)
            .parent(parent)
            // .bannerMode(Banner.Mode.OFF)
            .initializers(new ReporterApplicationContextInitializer(user))
            .web(WebApplicationType.NONE)
            .build()
            .run();
    }
}
