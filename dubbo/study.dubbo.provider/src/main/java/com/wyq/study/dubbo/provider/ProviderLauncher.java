package com.wyq.study.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.wyq.study.dubbo.provider.inject.Empty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 王艳群
 * @description ProvicerLauncher
 * @date 2020/10/9
 */
@SpringBootApplication
@EnableDubbo
public class ProviderLauncher {

    public static void main(String[] args) {
        SpringApplication.run(ProviderLauncher.class, args);

        /*ConfigurableApplicationContext context = new SpringApplicationBuilder(ProviderLauncher.class)
            .web(WebApplicationType.NONE)
            .run(args);
        buildChildContainer(context);*/

    }

    private static ConfigurableApplicationContext buildChildContainer(ConfigurableApplicationContext parent) {
        return new SpringApplicationBuilder(Empty.class)
            .parent(parent)
            // .bannerMode(Banner.Mode.OFF)
            .initializers()
            .web(WebApplicationType.NONE)
            .build()
            .run();
    }
}
