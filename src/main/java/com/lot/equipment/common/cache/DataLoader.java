package com.lot.equipment.common.cache;

/**
 * 数据加载接口
 * @param <T>
 */
public interface DataLoader<T> {

    /**
     * 缓存Key
     * @return
     */
    String key();

    /**
     * 加载数据
     * @return
     */
    T load();

    /**
     * 数据类型
     * @return
     */
    Class<T> dataType();

    /**
     * 缓存有效时间
     * @return
     */
    default Integer expired() {
        return 24 * 60 * 60;
    }

}
