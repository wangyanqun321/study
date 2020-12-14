package com.wyq.study.dubbo.runtime;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyq.study.dubbo.facade.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description Reporter
 * @date 2020/10/11
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Reporter {

    @Reference
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
