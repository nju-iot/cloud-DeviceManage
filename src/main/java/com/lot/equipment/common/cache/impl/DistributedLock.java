package com.lot.equipment.common.cache.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 分部署锁
 * @param <T>
 */
@Slf4j
@Component
public class DistributedLock<T> {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 尝试获取锁
     * @param keys
     * @param bizHandle
     * @return
     */
    public T tryLock(List<String> keys, BizHandle<T> bizHandle) {
        RedissonRedLock multiLock = getRedissonRedLock(keys);
        try {
            boolean isLock = multiLock.tryLock();
            if (isLock) {
                return bizHandle.run();
            } else {
                log.error("DistributedLock failed, {}", JSON.toJSONString(keys));
                throw new IllegalStateException("DistributedLock error");
            }
        } finally {
            multiLock.unlock();
        }
    }

    public T tryLock(List<String> keys, BizHandle<T> bizHandle, Integer seconds) {
        RedissonRedLock multiLock = getRedissonRedLock(keys);
        try {
            boolean isLock = multiLock.tryLock(seconds, seconds, TimeUnit.SECONDS);
            if (isLock) {
                return bizHandle.run();
            } else {
                log.error("DistributedLock failed, {}", JSON.toJSONString(keys));
                throw new IllegalStateException("DistributedLock error");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("get lock failed", e);
        } finally {
            multiLock.unlock();
        }
    }

    private RedissonRedLock getRedissonRedLock(List<String> keys) {
        RLock[] rLocks = new RLock[keys.size()];
        int i = 0;
        for (; i < keys.size(); i++) {
            RLock lock = redissonClient.getLock("wms:distributedLock:" + keys.get(i));
            rLocks[i] = lock;
        }
        return new RedissonRedLock(rLocks);
    }


    public interface BizHandle<T> {
        T run();
    }
}
