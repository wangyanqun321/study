package com.wyq.mysql.lock;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 王艳群
 * @description TestMap
 * @date 2020/11/19
 */
public class TestMap {
    private static Map<String, String> map = new Hashtable<>();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            final int temp = i;
            executorService.submit(() -> put(temp));
        }
        executorService.shutdown();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(map.size());
    }

    public static void put(int i) {
        String temp = i % 100 + "";
        map.put(temp,  temp);
    }
}
