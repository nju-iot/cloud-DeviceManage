package com.lot.equipment.common.cache;

public abstract class AbstractCache implements Cache {

    @Override
    public <T> T get(DataLoader<T> dataLoader) {
        T value = getFromCache(dataLoader.key(), dataLoader.dataType());
        if (value != null) {
            return value;
        } else {
            T data = dataLoader.load();
            if (data != null) {
                putIntoCache(dataLoader.key(), data, dataLoader.expired());
            }
            return data;
        }
    }

    protected abstract <T> T getFromCache(String key, Class<T> c);

    protected abstract void putIntoCache(String key, Object value, Integer expired);
}

