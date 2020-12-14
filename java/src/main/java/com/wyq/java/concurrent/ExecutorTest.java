package com.wyq.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 王艳群
 * @description ExecutorTest
 * @date 2020/9/12
 */
public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++) {
            final int index = i;
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-----" + index);
            });
        }
        executorService.shutdown();
        while (true) {
            if(executorService.isTerminated()) {
                System.out.println("线程池执行完毕！");
                break;
            }
        }
        System.out.println("主线程完成！");
    }
}
