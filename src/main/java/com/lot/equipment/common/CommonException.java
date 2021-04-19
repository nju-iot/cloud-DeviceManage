package com.lot.equipment.common;


public class CommonException extends BaseException {

    public CommonException(ErrorCode errorCode) {
        super(errorCode);
    }

    public CommonException(ErrorCode errorCode, String... args) {
        super(errorCode, args);
    }

    @Override
    protected String getType() {
        return "CommonException";
    }
}
