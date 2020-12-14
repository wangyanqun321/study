package com.wyq.flink.connector.custom;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Properties;

/**
 * @author 王艳群
 * @description WheatherSource
 * @date 2020/9/14
 */
public class WeatherSource {

    public static void main(String[] args) throws Exception {
        // 构建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        //这里是由一个kafka
        properties.setProperty("bootstrap.servers", "hadoop001:9092,hadoop002:9092,hadoop003:9092");
        properties.setProperty("group.id", "flink_consumer");
        //第一个参数是topic的名称
        WeatherSourceFunction weatherSourceFunction = new WeatherSourceFunction();
        DataStreamSource dataSource = env.addSource(weatherSourceFunction);
        dataSource.print();
        env.execute();
        Thread.sleep(10000);
        weatherSourceFunction.cancel();
    }
}
