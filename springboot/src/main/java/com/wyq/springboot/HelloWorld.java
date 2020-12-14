package com.wyq.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description HelloWorld
 * @date 2020/10/2
 */
public class HelloWorld {
    public static void main(String[] args) {

        Class<SpringbootApplication> springbootApplicationClass = SpringbootApplication.class;

        SpringBootApplication annotation = springbootApplicationClass.getAnnotation(SpringBootApplication.class);
        System.out.println(annotation instanceof Component);
    }
}
