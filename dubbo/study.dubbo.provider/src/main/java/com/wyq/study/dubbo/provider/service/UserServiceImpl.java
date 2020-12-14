package com.wyq.study.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Maps;
import com.wyq.study.dubbo.facade.User;
import com.wyq.study.dubbo.facade.UserService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 王艳群
 * @description UserServiceImpl
 * @date 2020/10/9
 */
@Component
@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, User> userMap = Maps.newHashMap();

    @Override
    public void addUser(User user) {
        System.out.println("提供方收到消息");
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUser(Integer userId) {
        System.out.println("提供方收到消息");
        return userMap.get(userId);
    }
}
