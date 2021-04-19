package com.lot.equipment.common.enums;

public enum EquipmentStatus {
    /**
     *
     */
    DELETED(-1),
    SCRAP(0),
    NORMAL(1);

    private Integer code;

    EquipmentStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
