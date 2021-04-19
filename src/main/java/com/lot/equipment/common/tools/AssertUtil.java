package com.lot.equipment.common.tools;

import cn.hutool.core.util.StrUtil;
import com.lot.equipment.common.CommonException;
import com.lot.equipment.common.ErrorCode;

import java.util.Collection;

public abstract class AssertUtil {

    public static void isNotNull(Object object, ErrorCode resutlCode) throws CommonException {
        if (object == null) {
            throw new CommonException(resutlCode);
        }
    }

    public static void isNotBlank(String text, ErrorCode resutlCode) throws CommonException {
        if (StrUtil.isBlank(text)) {
            throw new CommonException(resutlCode);
        }
    }

    public static void notEmpty(Collection<?> collection,
        ErrorCode resutlCode) throws CommonException {
        if (collection == null || collection.size() == 0) {
            throw new CommonException(resutlCode);
        }
    }

    public static void isTrue(boolean expression, ErrorCode resutlCode) throws CommonException {
        if (!expression) {
            throw new CommonException(resutlCode);
        }
    }


    public static void isFalse(boolean expression, ErrorCode resutlCode) throws CommonException {
        if (expression) {
            throw new CommonException(resutlCode);
        }
    }
}
