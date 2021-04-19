package com.lot.equipment.common.tools;

public abstract class DateTimeUtil {

    public static Integer now() {
        return (int) System.currentTimeMillis() / 1000;
    }

}
