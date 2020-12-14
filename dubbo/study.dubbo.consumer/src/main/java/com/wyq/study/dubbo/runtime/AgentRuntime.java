package com.wyq.study.dubbo.runtime;

import com.wyq.study.dubbo.facade.User;

/**
 * @author 王艳群
 * @description AgentRuntime
 * @date 2020/10/11
 */
public class AgentRuntime {

    private Reporter reporter;

    private User user;

    public AgentRuntime(Reporter reporter, User user) {
        this.reporter = reporter;
        this.user = user;
    }

    public void createUser() {
        reporter.getUserService().addUser(user);
    }
}
