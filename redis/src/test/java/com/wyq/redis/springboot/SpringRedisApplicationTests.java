package com.wyq.redis.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 王艳群
 * @description SpringRedisApplicationTests
 * @date 2020/5/23
 */
@SpringBootTest
public class SpringRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSet() {
       redisTemplate.opsForValue().set("bb", "cc");
    }

    @Test
    public void testGet() {
        String result = redisTemplate.opsForValue().get("bb");
        System.out.println(result);
    }

    @Test
    public void decrement() {
        redisTemplate.opsForValue().decrement("cc");
    }

    @Test
    public void increment() {
        redisTemplate.opsForValue().increment("cc");
    }
}
