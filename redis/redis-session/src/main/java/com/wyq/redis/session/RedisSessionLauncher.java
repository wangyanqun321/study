package com.wyq.redis.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 王艳群
 * @description RedisSessionLauncher
 * @date 2020/8/25
 */
@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
public class RedisSessionLauncher {

    public static void main(String[] args) {
        SpringApplication.run(RedisSessionLauncher.class, args);
    }
}
