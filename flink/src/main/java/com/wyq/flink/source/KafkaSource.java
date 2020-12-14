package com.wyq.flink.source;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/**
 * @author 王艳群
 * @description KafkaSource
 * @date 2020/8/30
 */
public class KafkaSource {

    public static void main(String[] args) throws Exception {

        // create execution environment
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:9092");

        properties.setProperty("group.id", "flink_consumer");

        DataStream stream = env.addSource(new FlinkKafkaConsumer<>("wyq", new SimpleStringSchema(), properties));

        stream.map(new MapFunction() {

            @Override
            public Object map(Object value) throws Exception {
                return "Stream Value: " + value;
            }

        }).print();

        env.execute();
    }
}

