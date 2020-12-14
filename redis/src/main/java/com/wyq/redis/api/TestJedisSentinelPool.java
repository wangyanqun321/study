package com.wyq.redis.api;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 王艳群
 * @description TestJedisSentinelPool
 * @date 2020/5/24
 */
public class TestJedisSentinelPool {
    //注意，Dubug测试该方法时要保证linux系统的防火墙关闭（centos7关闭指令为systemctl stop firewalld）
    public static void main(String[] args) {
        /*
         * 创建一个jedis连接池，不过该连接池创建的jedis对象所连接的Redis是被Sentinel监控的主节点
         * masterName表示Sentinel配置中的Redis主节点名
         * sentinels表示所有的Sentinel节点的IP地址与端口号信息
         * poolConfig表示该连接池的相关配置参数
         */
        String masterName="myredis";
        Set<String> sentinels=new LinkedHashSet<>();
        sentinels.add("hadoop001:26379");
        /*sentinels.add("192.168.10.128:26381");
        sentinels.add("192.168.10.128:26382");*/
        GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
        JedisSentinelPool pool=new JedisSentinelPool(masterName, sentinels, poolConfig);
        Jedis jedis=null;
        try {
            //注意，这里返回的jedis对象连接的仍然是Redis节点，并不是sentinel节点
            jedis=pool.getResource();
            System.out.println(pool.getCurrentHostMaster());
            //通过jedis就可以执行Redis的相关命令
            String response=jedis.get("user");
            System.out.println(response);
        } catch (Exception e) {
            // 异常处理
        }finally {
            if(jedis!=null){
                //回收jedis连接对象
                jedis.close();
            }
        }
    }

}
