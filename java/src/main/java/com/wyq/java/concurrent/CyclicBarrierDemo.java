package com.wyq.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 王艳群
 * @description CyclicBarrierDemo
 * @date 2020/6/28
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("----------");
        });

        for(int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "就绪！");
                try {
                    cyclicBarrier.await();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "出发!");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }

}
