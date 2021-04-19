package com.lot.equipment.common.enums;

import com.lot.equipment.common.ErrorCode;

public enum CommonErrorCode implements ErrorCode {
    /**
     *
     */
    CODE_EMPTY("1001", "code empty"),
    NAME_EMPTY("1002", "name empty"),
    EUIPMENT_ID_EMPTY("1003", "equipmentId empty"),
    REASON_EMPTY("1004", "reason empty"),
    ;

    CommonErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
