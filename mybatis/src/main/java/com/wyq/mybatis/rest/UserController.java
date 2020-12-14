package com.wyq.mybatis.rest;

import com.wyq.mybatis.application.UserApplicationService;
import com.wyq.mybatis.mybatis.dataobject.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 王艳群
 * @description UserController
 * @date 2020/7/11
 */
@RestController
public class UserController {

    private UserApplicationService userApplicationService;

    private volatile int count = 0;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id) {
        count++;
        System.out.println("第" + count + "次请求成功！");
        return userApplicationService.getUser(id);
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        return "OK";
    }
}
