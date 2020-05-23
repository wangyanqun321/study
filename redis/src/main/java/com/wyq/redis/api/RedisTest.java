package com.wyq.redis.api;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * @author 王艳群
 * @description RedisClient
 * @date 2020/5/23
 */
public class RedisTest {

    private JedisCluster jedisCluster;

    private Jedis jedis;

    @Before
    public void setJedis(){
        // Set<HostAndPort> hosts = Sets.newHashSet(new HostAndPort("hadoop001", 6379));
        //jedisCluster = new JedisCluster(hosts);
        jedis = new Jedis("hadoop001", 6379);
    }

    @Test
    public void setKey() {
        String result = jedis.set("bbb", "ccc");
        System.out.println(result);
    }

    @Test
    public void setnx() {
        Long result = jedis.setnx("bbb", "ccc");
        System.out.println(result);
    }

    @Test
    public void setex() {
        String result = jedis.setex("bbb",10, "ccc");
        System.out.println(result);
    }

    @Test
    public void getKey() {
        String result = jedis.get("bbb");
        System.out.println(result);
    }

}
