package com.draven.demo.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void add(String key, String user, Long time) {
        stringRedisTemplate.opsForValue().set(key, user, time, TimeUnit.MINUTES);
    }

    public String get(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return source;
        }
        return null;
    }

    public void delete(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }
}