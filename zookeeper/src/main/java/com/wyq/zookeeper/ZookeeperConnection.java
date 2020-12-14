package com.wyq.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 王艳群
 * @description ZookeeperConnection
 * @date 2020/5/26
 */
public class ZookeeperConnection {
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("hadoop001:2181,hadoop002:2181,hadoop003:2181",
            5000, new Watcher() {

            CountDownLatch countDownLatch = new CountDownLatch(1);

            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接创建成功");
                    countDownLatch.countDown();
                }
            }
        });
        System.out.println(zooKeeper.getSessionId());
        //zooKeeper.close();
    }

}
