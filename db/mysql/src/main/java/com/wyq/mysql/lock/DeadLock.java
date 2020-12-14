package com.wyq.mysql.lock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 王艳群
 * @description DeadLock
 * @date 2020/8/16
 */
public class DeadLock {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        new Thread(DeadLock::thread1).start();
        new Thread(DeadLock::thread2).start();

    }

    private static void thread1() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("select * from flink_sink where id=4 for update");
            pst.executeQuery();
            Thread.sleep(1000);
            PreparedStatement pst2 = conn.prepareStatement("update flink_sink set content='5555' where id=5");
            pst2.execute();
            conn.commit();
        }catch (Exception e) {
            System.out.println("thread1: " + e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    private static void thread2() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("select * from flink_sink where id=5 for update");
            pst.executeQuery();
            Thread.sleep(1000);
            PreparedStatement pst2 = conn.prepareStatement("update flink_sink set content='4444' where id=4");
            pst2.execute();
            conn.commit();
        }catch (Exception e) {
            System.out.println("thread2: " + e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
