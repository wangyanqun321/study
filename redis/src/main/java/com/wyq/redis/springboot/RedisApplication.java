package com.wyq.redis.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/test-get")
    public String testGet() {
        System.out.println("test get");
        return stringRedisTemplate.opsForValue().get("aa");
    }

    @GetMapping("/test-set")
    public String testSet(String value) {
        System.out.println("test set");
        stringRedisTemplate.opsForValue().set("aa", value);
        return "test";
    }

}
