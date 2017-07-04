package com.itinybean.template.spring.boot;

import com.itinybean.template.spring.boot.configuration.RedisConfiguration;
import com.itinybean.template.spring.boot.listeners.SpringApplicationStartupListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author roger
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.itinybean.template.spring.boot")
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class, RedisConfiguration.class)
                .listeners(new SpringApplicationStartupListener())
                .run(args);
    }

}
