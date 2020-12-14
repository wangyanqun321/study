package com.wyq.flink.connector.custom;

import com.wyq.study.flink.common.RealTimeWeather;
import com.wyq.study.flink.common.Weather;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * @author 王艳群
 * @description WeatherSource
 * @date 2020/9/14
 */
public class WeatherSourceFunction implements SourceFunction<Weather> {

    private volatile boolean running = true;

    @Override
    public void run(SourceContext<Weather> sourceContext) throws Exception {
        while(running) {
            String weatherJson = RealTimeWeather.weatherJson();
            Weather weather = RealTimeWeather.parse(weatherJson);
            sourceContext.collect(weather);
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        running = false;
    }
}
