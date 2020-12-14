package com.wyq.zookeeper.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王艳群
 * @description ZookeeperLockTest
 * @date 2020/10/5
 */
public class ZookeeperLockTest {

    public static final int thread_num = 50;
    public static AtomicInteger success = new AtomicInteger();
    public static AtomicInteger failed = new AtomicInteger();
    public static void main(String[] args) throws Exception{
        ZookeeperSession zookeeperSession = ZookeeperSession.getInstance();
        CountDownLatch countDownLatch = new CountDownLatch(thread_num);
        for (int i = 0; i < thread_num; i++) {
            new Thread(() -> {
                //Long resourceId = new Random().nextLong()%2==0 ? 1L : 2L;
                Long resourceId = 1L;
                Boolean aBoolean = zookeeperSession.acquireDistributedLock(resourceId);
                if(aBoolean){
                    success.incrementAndGet();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    zookeeperSession.releaseDistributedLock(resourceId);
                } else {
                    failed.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("=============成功数：" + success.get());
        System.out.println("=============失败数：" + failed.get());
        //new Scanner(System.in).next();
    }

}
