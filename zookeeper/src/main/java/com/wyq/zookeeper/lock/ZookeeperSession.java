package com.wyq.zookeeper.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 王艳群
 * @description ZookeeperSession
 * @date 2020/10/5
 */
public class ZookeeperSession {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    /**
     * Zookeeper连接对象
     */
    private ZooKeeper zooKeeper;
    /**
     * 本地连接控制
     */
//    private CountDownLatch latch;  注解：①

        // 正在的分布式场景下不会用ConcurrentLinkedQueue，需要用分布式队列
    private ConcurrentLinkedQueue<CountDownLatch> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    private static Logger log = LoggerFactory.getLogger(ZookeeperSession.class);

    public synchronized static ZookeeperSession getInstance(){
        return new ZookeeperSession();
    }

    private ZookeeperSession() {
        try {
            zooKeeper = new ZooKeeper("hadoop001:2181,hadoop002:2181,hadoop003:2181", 5000, new ZookeeperWatcher());
            try {
                connectedSemaphore.await();  // 注解：②
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("ZooKeeper session established......");
        } catch (IOException e) {
            log.error("初始化zooKeeper出错，发生IO异常");
            e.printStackTrace();
        }
    }

    /*private static class ZookeeperSessionSingleton {
        private static ZookeeperSession instance = new ZookeeperSession();
    }*/

    /**
     * 自实现Zookeeper监听器
     */
    private class ZookeeperWatcher implements Watcher {

        @Override
        public void process(WatchedEvent event) {
            System.out.println("[" + Thread.currentThread().getName() + "] 监听到事件状态:" + event.getState() + ", 事件类型: " + event.getType());
            if (Event.KeeperState.SyncConnected == event.getState()) {
                // 触发完成zookeeper对象的初始化
                connectedSemaphore.countDown();
            }

            // 所有事件，唤醒阻塞线程争夺锁
            CountDownLatch latch = concurrentLinkedQueue.poll();
            System.out.println("[" + Thread.currentThread().getName() + "] get CountDownLatch from concurrentQueue:" + latch);
            if (latch != null) {
                // 这里线程不安全，如果一个新的线程把该
                latch.countDown();
            }
        }

    }


    public Boolean acquireDistributedLock2(Long resourceId) {
        String path = "/resource-lock-" + resourceId;
        while(true) {
            try {
                Stat stat = zooKeeper.exists(path, true);
                // 锁被其他线程占用
                if(stat != null) {
                    // 阻塞当前线程直到继续获取到抢锁机会
                    CountDownLatch latch = new CountDownLatch(1);
                    concurrentLinkedQueue.add(latch);
                    latch.await();
                }else {
                    // 获取到锁
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*try {
            // 相当于是给node注册一个监听器，去看看这个监听器是否存在
            // true使用watcher，这里的watcher是在创建 ZooKeeper实例时指定的 watcher，
            // 需要注意的是，每个watcher只能用一次，所以这里每次都会一个新的watcher
            Stat stat = zooKeeper.exists(path, true);
            if (stat != null) {
                System.out.println("[" + Thread.currentThread().getName() +"] stat is not null");
                CountDownLatch latch = new CountDownLatch(1);
                System.out.println("[" + Thread.currentThread().getName() +"] put CountDownLatch in the concurrentQueue:" + latch);
                concurrentLinkedQueue.add(latch);
                boolean await = latch.await(5000, TimeUnit.MILLISECONDS);  // 注解：③
                System.out.println("[" + Thread.currentThread().getName() +"] thread is wakeup" + ", await:" + await);
                if(!await){
                    return false;
                }
            }
            zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            // 再次触发监听(监听下一次的删除节点事件)
            zooKeeper.getData(path,true,null);  // 注解：④
            System.out.println("[" + Thread.currentThread().getName() +"] acquire the lock for resource[id=" + resourceId + "]......");
            return true;
        } catch (Exception ee) {
            ee.printStackTrace();
        }*/
        //return true;
    }


    /**
     * 获取分布式锁
     *
     * @param resourceId
     */
    public Boolean acquireDistributedLock(Long resourceId) {
        String path = "/resource-lock-" + resourceId;
        try {
            // Ids.OPEN_ACL_UNSAFE 创建开放节点，允许任意操作
            // CreateMode.EPHEMERAL 同步创建临时节点会话关闭后它会自动被删除
            zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("[" + Thread.currentThread().getName() +"] acquire the lock for resource[id=" + resourceId + "]......");
            return true;
        } catch (Exception e) {
            while (true) {
                try {
                    // 相当于是给node注册一个监听器，去看看这个监听器是否存在
                    // true使用watcher，这里的watcher是在创建 ZooKeeper实例时指定的 watcher，
                    // 需要注意的是，每个watcher只能用一次，所以这里每次都会一个新的watcher
                    Stat stat = zooKeeper.exists(path, true);
                    if (stat != null) {
                        System.out.println("[" + Thread.currentThread().getName() +"] stat is not null");
                        CountDownLatch latch = new CountDownLatch(1);
                        //System.out.println("[" + Thread.currentThread().getName() +"] put CountDownLatch in the concurrentQueue:" + latch);
                        concurrentLinkedQueue.add(latch);
                        boolean await = latch.await(10050, TimeUnit.MILLISECONDS);  // 注解：③
                        System.out.println("[" + Thread.currentThread().getName() +"] thread is wakeup" + ", await:" + await);
                        if(!await){
                            return false;
                        }
                    }
                    zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                    // 再次触发监听(监听下一次的删除节点事件)
                    Thread.sleep(20);
                    zooKeeper.getData(path,true,null);  // 注解：④
                    System.out.println("[" + Thread.currentThread().getName() +"] acquire the lock for resource[id=" + resourceId + "]......");
                    return true;
                } catch (Exception ee) {
                    System.out.println("节点存在了，重复创建");
                    ee.printStackTrace();
                }
            }

        }
    }

    /**
     * 释放掉一个分布式锁
     *
     * @param resourceId
     */
    public void releaseDistributedLock(Long resourceId) {
        String path = "/resource-lock-" + resourceId;
        try {
            // -1参数代表不在意版本号都删除
            zooKeeper.delete(path, -1);
            System.out.println("[" + Thread.currentThread().getName() +"] release the lock for resource[id=" + resourceId + "]......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 防止反序列化对单例的破坏
     * @return 单例对象
     */
    /*Object readResolve() {
        return ZookeeperSessionSingleton.instance;
    }*/
}