package com.wyq.flink.connector.jdbc;

import com.wyq.flink.connector.custom.RandomData;
import com.wyq.flink.connector.custom.RandomSourceFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author 王艳群
 * @description MysqlSink
 * @date 2020/9/14
 */
public class MysqlSink {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<RandomData> dataSource = env.addSource(new RandomSourceFunction());
        dataSource.addSink(new MysqlSinkFunction());
        env.execute("test flink kafka producer");
    }
}
