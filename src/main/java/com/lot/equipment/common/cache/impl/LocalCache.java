package com.lot.equipment.common.cache.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.lot.equipment.common.cache.AbstractCache;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("LocalCache")
public class LocalCache extends AbstractCache {

    private static Map<String, String> cacheData = new ConcurrentHashMap<>();

    @Override
    protected <T> T getFromCache(String key, Class<T> c) {
        key = key.toLowerCase();
        String value = cacheData.get(key);
        if (StrUtil.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, c);
    }

    @Override
    protected void putIntoCache(String key, Object value, Integer expired) {
        key = key.toLowerCase();
        cacheData.put(key, JSON.toJSONString(value));
    }

    @Override
    public void release(String key) {
        key = key.toLowerCase();
        cacheData.remove(key);
    }

    @Override
    public void update(String key, Object t) {
        key = key.toLowerCase();
        cacheData.put(key, JSON.toJSONString(t));
    }
}
