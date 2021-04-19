package com.lot.equipment.common.enums;

public enum EquipmentScrapStatus {
    /**
     *
     */
    DELETED(-1),
    NORMAL(1);

    private Integer code;

    EquipmentScrapStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
