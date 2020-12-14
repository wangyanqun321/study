package com.wyq.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author 王艳群
 * @description KafkaConsumer
 * @date 2020/8/30
 */
public class BaseKafkaConsumer {

    private String groupId;

    private String topic;

    public BaseKafkaConsumer(String groupId, String topic) {
        this.groupId = groupId;
        this.topic = topic;
    }

    public KafkaConsumer<String, String> getConsumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "hadoop001:9092,hadoop002:9092,hadoop003:9092");
        props.put("group.id", this.groupId);//指定消费者属于哪个组
        props.put("enable.auto.commit", "true");//开启kafka的offset自动提交功能，可以保证消费者数据不丢失
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
        return consumer;
    }

    public void poll() {
        Consumer<String, String> consumer = getConsumer();
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("=============");
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }
}
