package com.wyq.redis.api;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * @author 王艳群
 * @description RedisClusterTest
 * @date 2020/5/24
 */
public class RedisClusterTest {
    private JedisCluster jedisCluster;

    @Before
    public void setJedis() throws InterruptedException {
    }

    @Test
    public void setKey() throws InterruptedException {
        Jedis master = new Jedis("hadoop001",6379);//主机
        Jedis slave1 = new Jedis("hadoop002",6379);//从机
        Jedis slave2 = new Jedis("hadoop003",6379);//从机

        //遵循“配从不配主”的模式
        slave1.slaveof("hadoop001",6379);
        slave2.slaveof("hadoop001",6379);

        master.set("class2", "class2");//主机去写

        //内存中读写太快，防止读在写之前先完成而出现null的情况，这里做一下延迟
        Thread.sleep(2000);

        String result = slave1.get("class2");//从机去读
        System.out.println(result);
    }
}
