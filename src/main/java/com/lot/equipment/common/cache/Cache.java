package com.lot.equipment.common.cache;

/**
 * 缓存接口
 */
public interface Cache {

    /**
     * 获取数据，添加进换粗
     * @param dataLoader
     * @param <T>
     * @return
     */
    <T> T get(DataLoader<T> dataLoader);

    /**
     * 释放缓存
     * @param key
     */
    void release(String key);

    /**
     * 更新环境信息
     * @param key
     * @param t
     */
    void update(String key, Object t);
}
