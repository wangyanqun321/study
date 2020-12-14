package com.wyq.study.dubbo.provider.controller;

import com.wyq.study.dubbo.facade.User;
import com.wyq.study.dubbo.provider.service.UserServiceImpl;
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
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public boolean testAddUser(int id, String name) {
        userService.addUser(new User(id, name));
        return true;
    }

    @GetMapping
    public User getUser(int id) {
        return userService.getUser(id);
    }
}
