package com.wyq.java.thread;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 王艳群
 * @description ThreadTest
 * @date 2020/10/6
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程开始执行");
                    Thread.sleep(1000);
                    System.out.println("子线程执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join(100);
        System.out.println("主线程执行完了");
    }

}
