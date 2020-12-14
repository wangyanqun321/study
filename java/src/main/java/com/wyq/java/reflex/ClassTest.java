package com.wyq.java.reflex;

import java.lang.reflect.Field;

/**
 * @author 王艳群
 * @description ClassTest
 * @date 2020/9/27
 */
public class ClassTest {

    public static void main(String[] args) throws Exception {
        Class<User> dogClass = User.class;
        Field dog = dogClass.getDeclaredField("dog");
        dog.setAccessible(true);
        User user = new User();
        Class<?> dogType = dog.getType();
        Object o = dogType.newInstance();
        dog.set(user, o);
        System.out.println(user);
    }
}
