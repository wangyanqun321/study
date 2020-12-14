package com.wyq.hive.jdbc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.IntStream;

/**
 * @author 王艳群
 * @description TestHive
 * @date 2020/8/17
 */
public class TestHive {

    @Test
    public void getConnect() {
        //String url = "jdbc:hive2://hadoop001:10000/default";
        String url = "jdbc:hive2://hadoop001:2181,hadoop001:2181,hadoop001:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2_zk";
        String username = "hive";
        String password = "cloudera";
        try(Connection connection = HiveOperator.getConnection(url, username, password)) {
            PreparedStatement pst = connection.prepareStatement("select * from wyq.test");
            ResultSet resultSet = pst.executeQuery();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for(int column = 1; column <= columnCount; column++) {
                    System.out.print(resultSet.getObject(column) + ",");
                }
                System.out.println();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getConnect2() {
        //String url = "jdbc:hive2://hadoop001:10000/default";
        String url = "jdbc:hive2://192.168.240.150:10000/";
        String username = "hive";
        String password = "cloudera";
        try(Connection connection = HiveOperator.getConnection(url, username, password)) {
            PreparedStatement pst = connection.prepareStatement("alter table wyq.hello add column (age int)");
            pst.execute();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
