package com.wyq.study.dubbo.facade;

/**
 * @Description: UserService
 * @Author: 王艳群
 * @Date: 2020/10/9
 */
public interface UserService {

    void addUser(User user);

    User getUser(Integer userId);

}
