package com.wyq.flink.connector.jdbc;

import com.wyq.flink.connector.custom.RandomData;
import com.wyq.study.flink.common.Weather;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author 王艳群
 * @description MysqlSinkFunction
 * @date 2020/9/14
 */
public class MysqlSinkFunction extends RichSinkFunction<RandomData> {

    private Connection connection;

    @Override
    public void open(Configuration parameters) throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flink", "root", "123456");
    }

    @Override
    public void close() throws Exception {
        System.out.println("即将关闭连接！");
        connection.close();
    }

    @Override
    public void invoke(RandomData value, Context context) throws Exception {
        PreparedStatement pst = connection.prepareStatement("insert into flink_jdbc_slink(name, age, email) values(?, ?, ?)");
        pst.setString(1, value.getName());
        pst.setInt(2, value.getAge());
        pst.setString(3, value.getEmail());
        pst.execute();
        System.out.println("插入数据：" + value);
    }
}
