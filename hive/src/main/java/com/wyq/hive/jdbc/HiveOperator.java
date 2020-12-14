package com.wyq.hive.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 王艳群
 * @description HiveOperator
 * @date 2020/8/17
 */
public class HiveOperator {

    private static String DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";

    public static Connection getConnection(String url, String username, String password) {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
