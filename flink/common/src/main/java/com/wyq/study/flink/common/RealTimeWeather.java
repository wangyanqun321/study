package com.wyq.study.flink.common;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 王艳群
 * @description com.wyq.study.flink.common.RealTimeWeather
 * @date 2020/9/14
 */
public class RealTimeWeather {

    public static void main(String[] args) {
        weatherJson();
    }

    public static String weatherJson() {
    // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://api.k780.com/?app=weather.realtime" +
            "&weaid=1" +
            "&ag=today,futureDay,lifeIndex,futureHour" +
            "&appkey=10003" +
            "&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return EntityUtils.toString(responseEntity);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Weather parse(String weatherJson) {
        Response response = JSON.parseObject(weatherJson, Response.class);
        System.out.println(response.getResult());
        return response.getResult();
    }
}
