package com.lot.equipment.common;

import lombok.Data;

import java.text.MessageFormat;

@Data
public abstract class BaseException extends RuntimeException {

    private String code;
    private String message;

    protected abstract String getType();

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public BaseException(ErrorCode errorCode, String... args) {
        super(MessageFormat.format(errorCode.getMessage(), args));
        this.code = errorCode.getCode();
        this.message = MessageFormat.format(errorCode.getMessage(), args);
    }
}
