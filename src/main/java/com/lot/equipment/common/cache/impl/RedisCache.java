package com.lot.equipment.common.cache.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.lot.equipment.common.cache.AbstractCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCache extends AbstractCache {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected <T> T getFromCache(String key, Class<T> c) {
        key = key.toLowerCase();
        String value = (String) redisTemplate.opsForValue().get(key);
        if (StrUtil.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, c);
    }

    @Override
    protected void putIntoCache(String key, Object value, Integer expired) {
        key = key.toLowerCase();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value), expired, TimeUnit.SECONDS);
    }

    @Override
    public void release(String key) {
        key = key.toLowerCase();
        redisTemplate.delete(key);
    }

    @Override
    public void update(String key, Object t) {
        key = key.toLowerCase();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(t), 0);
    }
}
