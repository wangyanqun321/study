package com.wyq.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 王艳群
 * @description MyBatisApplication
 * @date 2020/7/11
 */
@SpringBootApplication
@EnableSwagger2
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class);
    }

}
