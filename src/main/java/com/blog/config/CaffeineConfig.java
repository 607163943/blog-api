package com.blog.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineConfig {
    @Bean
    public Cache<String,Object> captchaCache() {
        return Caffeine.newBuilder()
                // 60s过期时间
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .maximumSize(100)
                .build();
    }
}
