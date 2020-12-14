package com.wyq.kafka;

/**
 * @author 王艳群
 * @description Myconsumer2
 * @date 2020/8/30
 */
public class MyConsumer2 extends BaseKafkaConsumer {

    public MyConsumer2(String groupId, String topic) {
        super(groupId, topic);
    }

    public static void main(String[] args) {
        new MyConsumer2("bb", "wyq").poll();
    }
}
