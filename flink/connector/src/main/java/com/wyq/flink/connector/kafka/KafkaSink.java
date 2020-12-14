package com.wyq.flink.connector.kafka;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

/**
 * @author 王艳群
 * @description WriteDataToKafka
 * @date 2020/8/30
 */
public class KafkaSink {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> dataStreamSource = env.readTextFile("F:\\wordcount.txt");
        dataStreamSource.addSink(new FlinkKafkaProducer<String>("hadoop001:9092,hadoop002:9092,hadoop003:9092",
            "wyq", new SimpleStringSchema()));
        env.execute("test flink kafka producer");
    }
}
