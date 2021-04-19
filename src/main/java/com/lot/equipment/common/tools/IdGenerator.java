package com.lot.equipment.common.tools;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

public abstract class IdGenerator {

    private static Snowflake snowflake;

    static {
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhost().hashCode();
        }
        snowflake = IdUtil.createSnowflake(workerId, 1);
    }

    public static String simpleUUID() {
        return IdUtil.simpleUUID();
    }

    public static String randomUUID() {
        return IdUtil.randomUUID();
    }

    public synchronized static String snowflakeId() {
        return snowflake.nextId() + "";
    }

    public String objectId() {
        return ObjectId.next();
    }

}
