package com.wyq.redis.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 王艳群
 * @description controller
 * @date 2020/8/25
 */
@RestController
public class TestSessionController {

    @GetMapping
    public String login(HttpSession session) {
        session.setAttribute("user_1",  "aa");
        return "login success";
    }

    @GetMapping("/getsession")
    public String testGetSession(HttpSession session) {
        return (String) session.getAttribute("user_1");
    }
}
