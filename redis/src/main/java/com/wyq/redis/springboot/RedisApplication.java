package com.wyq.redis.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王艳群
 * @description RedisApplication
 * @date 2020/5/23
 */
@SpringBootApplication
@RestController
public class RedisApplication {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class);
    }

    @GetMapping("/test")
    public String testGet() {
        stringRedisTemplate.opsForValue().set("aa", "bb");
        return "test";
    }

}
