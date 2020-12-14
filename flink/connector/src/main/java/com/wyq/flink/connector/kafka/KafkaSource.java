package com.wyq.flink.connector.kafka;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Date;
import java.util.Properties;

/**
 * @author 王艳群
 * @description ReadFromKafka
 * @date 2020/8/30
 */
public class KafkaSource {

    public static void main(String[] args) throws Exception {
        // 构建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        //这里是由一个kafka
        properties.setProperty("bootstrap.servers", "hadoop001:9092,hadoop002:9092,hadoop003:9092");
        properties.setProperty("group.id", "flink_consumer");
        //第一个参数是topic的名称
        FlinkKafkaConsumer<String> consumer011 = new FlinkKafkaConsumer<>("wyq", new SimpleStringSchema(), properties);
        DataStreamSource stream=env.addSource(consumer011);
        stream.map(new MapFunction<String, String>() {
            @Override
            public String map(String value) throws Exception {
                return new Date().toString()+":  " + value;
            }

        }).print();
        env.execute();


    }

}
