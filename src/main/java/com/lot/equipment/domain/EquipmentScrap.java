package com.lot.equipment.domain;

import lombok.Data;

/**
 * 设备报废类
 */
@Data
public class EquipmentScrap {

    /**
     * 报废id
     */
    private String id;
    /**
     * 设备编码
     */
    private String equipmentId;
    /**
     * 报废类型
     */
    private String type;
    /**
     * 报废原因
     */
    private String reason;
    /**
     * 报废状态
     */
    private Integer status;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer createdAt;
    private Integer updatedAt;
    private Integer deletedAt;
}
