package com.wyq.flink.connector.custom;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author 王艳群
 * @description RandomSourceFunction
 * @date 2020/9/14
 */
public class RandomSourceFunction implements SourceFunction<RandomData> {

    @Override
    public void run(SourceContext<RandomData> sourceContext) throws Exception {
        while (true) {
            RandomData randomData = new RandomData();
            randomData.setName(generateWord());
            Random random = new Random();
            randomData.setAge(random.nextInt(40) + 10);
            randomData.setEmail(generateEmail());
            sourceContext.collect(randomData);
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {

    }

    private String generateWord() {
        String[] beforeShuffle = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        return afterShuffle.substring(5, 9);
    }

    public static String generateEmail() {
        Random random = new Random();
        int number = random.nextInt(10000000) + 12345678;
        return number + "@qq.com";
    }

}
