package com.wyq.study.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.wyq.study.dubbo.injector.Empty;
import com.wyq.study.dubbo.runtime.Reporter;
import com.wyq.study.dubbo.runtime.ReporterApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 王艳群
 * @description comsumer
 * @date 2020/10/9
 */
@SpringBootApplication
@EnableDubbo
// @EnableSwagger2
public class ConsumerLauncher {

    public static void main(String[] args) {
        /*ConfigurableApplicationContext context = new SpringApplicationBuilder(ConsumerLauncher.class)
            .web(WebApplicationType.NONE)
            .run(args);*/
        ConfigurableApplicationContext run = SpringApplication.run(ConsumerLauncher.class, args);
        // buildChildContainer(context);
    }

    /*private static ConfigurableApplicationContext buildChildContainer(ConfigurableApplicationContext parent) {
        return new SpringApplicationBuilder(Empty.class)
            .parent(parent)
            // .bannerMode(Banner.Mode.OFF)
            .initializers(new ReporterApplicationContextInitializer())
            .web(WebApplicationType.NONE)
            .build()
            .run();
    }*/

}
