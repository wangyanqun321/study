package com.wyq.springboot.controller;

import com.wyq.springboot.application.MailApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王艳群
 * @description EmailController
 * @date 2020/10/11
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    private MailApplicationService mailApplicationService;

    public EmailController(MailApplicationService mailApplicationService) {
        this.mailApplicationService = mailApplicationService;
    }

    @PostMapping("/send")
    public boolean send(String to, String subject, String content) {
        mailApplicationService.send(to, subject, content);
        return true;
    }
}
