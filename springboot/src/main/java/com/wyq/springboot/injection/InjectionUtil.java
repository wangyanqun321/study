package com.wyq.springboot.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description injectionUtil
 * @date 2020/8/23
 */
@Component
public class InjectionUtil {

    private static String username;

    private static String password;

    @Value("${injection.username}")
    public void setPassword(String password) {
        System.out.println("注入静态变量:" + password);
        InjectionUtil.password = password;
    }

    @Value("${injection.password}")
    public void setUsername(String username) {
        System.out.println("注入静态变量:" + username);
        InjectionUtil.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

}
