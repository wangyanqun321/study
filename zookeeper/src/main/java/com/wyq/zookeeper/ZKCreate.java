package com.wyq.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 王艳群
 * @description ZKCreate
 * @date 2020/5/26
 */
public class ZKCreate {

    ZooKeeper zooKeeper;

    @Before
    public void before() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper("hadoop001:2181,hadoop002:2181,hadoop003:2181", 1000, new Watcher() {

            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接创建成功");
                    countDownLatch.countDown();
                }
                System.out.println("监听到事件类型为：" + watchedEvent.getType());
            }
        });
        countDownLatch.await();
    }

    @After
    public void after() throws Exception {
        // zooKeeper.close();
    }

    @Test
    public void create1() throws KeeperException, InterruptedException {
        String s = zooKeeper.create("/create2", "create1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //System.out.println(s);
        Stat create3 = zooKeeper.exists("/create", true);
        //System.out.println(create3);
        Thread.sleep(2000);
        //zooKeeper.delete("/create", -1);
    }

    @Test
    public void get() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/", true);
        System.out.println(children);
    }

    @Test
    public void exists() throws KeeperException, InterruptedException {
        while(true) {
            Thread.sleep(1000);
            Stat exists = zooKeeper.exists("/create", true);
            System.out.println(exists);
        }
    }

    @Test
    public void delete() throws KeeperException, InterruptedException {
        zooKeeper.delete("/create", -1);
    }

    @Test
    public void getData() throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData("/create10", true, null);
        System.out.println(data == null);
    }

}
