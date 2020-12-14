package com.wyq.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;

/**
 * @author 王艳群
 * @description HadoopTest
 * @date 2020/5/30
 */
public class HadoopTest {


    public static void main(String[] args) throws IOException {
        System.setProperty("HADOOP_USER_NAME", "hdfs");
        Configuration conf = new Configuration();

        /*conf.set("dfs.nameservices", "nameservice1");
        conf.set("fs.defaultFS", "hdfs://nameservice1:8020");
        conf.set("dfs.client.failover.proxy.provider.nameservice1", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
        conf.set("dfs.ha.namenodes.nameservice1", "namenode27,namenode63");
        conf.set("dfs.namenode.rpc-address.nameservice1.namenode27", "hadoop001:8020");
        conf.set("dfs.namenode.servicerpc-address.nameservice1.namenode27", "hadoop001:8022");
        conf.set("dfs.namenode.http-address.nameservice1.namenode27", "hadoop001:50070");
        conf.set("dfs.namenode.https-address.nameservice1.namenode27", "hadoop001:50470");

        conf.set("dfs.namenode.rpc-address.nameservice1.namenode63", "hadoop002:8020");
        conf.set("dfs.namenode.servicerpc-address.nameservice1.namenode63", "hadoop002:8022");
        conf.set("dfs.namenode.http-address.nameservice1.namenode63", "hadoop002:50070");
        conf.set("dfs.namenode.https-address.nameservice1.namenode63", "hadoop002:50470");*/
        /*conf.set("dfs.namenode.name.dir", "file:///var/lib/hadoop-hdfs/cache/hdfs/dfs/name");
        conf.set("dfs.namenode.servicerpc-address", "quickstart.cloudera:8022");
        conf.set("dfs.https.address", "quickstart.cloudera:50470");
        conf.set("dfs.https.port", "50470");
        conf.set("dfs.namenode.http-address", "quickstart.cloudera:50070");*/
        // conf.set("fs.defaultFS", "hdfs://quickstart.cloudera:8020");
        conf.addResource("hdfs-site.xml");
        conf.set("fs.defaultFS", "hdfs://hadoop001:8020");
        FileSystem fs = FileSystem.newInstance(conf);
        //fs.delete(new Path("/wyq"), true);
        //fs.mkdirs(new Path("/wyq"), new FsPermission("777"));
        fs.mkdirs(new Path("/wyq/test"));
        fs.setPermission(new Path("/wyq/test"), new FsPermission("777"));
    }
}
