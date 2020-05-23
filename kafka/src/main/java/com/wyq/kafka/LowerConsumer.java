package com.wyq.kafka;

import com.google.common.collect.Lists;
import kafka.javaapi.consumer.SimpleConsumer;

import java.util.List;

/**
 * @author 王艳群
 * @description LowerConsumer
 * @date 2020/5/23
 */
public class LowerConsumer {

    public static void main(String[] args) {
        List<String> brokers = Lists.newArrayList("hadoop001", "hadoop002", "hadoop003");
        int port = 9092;
        String topic = "first";
        int partition = 0;
        long offset = 0;
    }

    private String findLeader(List<String> brokers, int port, String topic, int partition) {
        return null;
    }

    // 获取数据
    private void getData() {

    }

}
