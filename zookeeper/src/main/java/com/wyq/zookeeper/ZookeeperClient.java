package com.wyq.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author 王艳群
 * @description ZookeeperClient
 * @date 2020/8/20
 */
public class ZookeeperClient {

    public static void main(String[] args) {
        ZookeeperClient client = new ZookeeperClient("192.168.240.150:2181");
        //String result = client.create("/test", "test_aa");
        String result = client.get("/test");
        System.out.println(result);
    }

    private ZooKeeper zooKeeper;

    public ZookeeperClient(String connectString) {
        zooKeeper = getZooKeeper(connectString);
    }

    private ZooKeeper getZooKeeper(String connectString) {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(connectString, 5000,
                event -> Watcher.Event.KeeperState.SyncConnected.equals(event.getState()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zooKeeper;

    }

    public String create(String path, String data) {
        try {
            return zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String get(String path) {
        byte[] data = new byte[0];
        try {
            data = zooKeeper.getData(path, false, new Stat());
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return new String(data);
    }


}
