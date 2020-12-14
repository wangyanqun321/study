package com.wyq.kafka;

/**
 * @author 王艳群
 * @description MyConsumer1
 * @date 2020/8/30
 */
public class MyConsumer1 extends BaseKafkaConsumer {

    public MyConsumer1(String groupId, String topic) {
        super(groupId, topic);
    }

    public static void main(String[] args) {
        new MyConsumer1("aa", "wyq").poll();
    }
}
