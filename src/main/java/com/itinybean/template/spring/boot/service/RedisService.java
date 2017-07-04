package com.itinybean.template.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author roger
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostConstruct
    public void init() {
        System.out.println("=====> redis init.");
        JedisConnectionFactory factory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
        System.out.println("=====> redis connection timeout: " + factory.getTimeout());

        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000L);
                System.out.println(i);
            } catch (InterruptedException e) {
            }
        }

        String value = redisTemplate.opsForValue().get("test:test");
        System.out.println("=====> redis key [test:test], value: " + value);
    }

}
