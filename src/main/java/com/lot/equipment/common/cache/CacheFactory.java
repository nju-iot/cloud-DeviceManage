package com.lot.equipment.common.cache;

import com.lot.equipment.common.cache.impl.LocalCache;
import com.lot.equipment.common.cache.impl.RedisCache;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 缓存工厂
 */
@Component
public class CacheFactory {

    private static CacheFactory cacheFactory;

    @Autowired
    private BeanFactory beanFactory;

    /**
     * 类初始化后，执行信息初始化
     */
    @PostConstruct
    public void init() {
        cacheFactory = this;
        cacheFactory.beanFactory = this.beanFactory;
    }

    /**
     * 根据不同的缓存类型获取缓存处理类
     * @param cacheType
     * @return
     */
    public static Cache getCache(CacheType cacheType) {
        switch (cacheType) {
            case LOCAL:
                return cacheFactory.beanFactory.getBean(LocalCache.class);
            case REDIS:
                return cacheFactory.beanFactory.getBean(RedisCache.class);
            default:
                throw new IllegalArgumentException("cache type cannot instance.");
        }
    }
}
