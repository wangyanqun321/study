package com.wyq.mysql.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 王艳群
 * @description JdumpTest
 * @date 2020/11/22
 */
public class JdumpTest {

    public static void main(String[] args) {
        String aaa = "hello world";
        List<String> list = new ArrayList<>();
        boolean isAdd = true;
        while (isAdd) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println(list);
        System.out.println(aaa);
    }
}
