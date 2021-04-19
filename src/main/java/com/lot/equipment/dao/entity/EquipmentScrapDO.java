package com.lot.equipment.dao.entity;

import lombok.Data;

@Data
public class EquipmentScrapDO {

    private String id;
    private String equipmentId;
    private String type;
    private String reason;
    private Integer status;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer createdAt;
    private Integer updatedAt;
    private Integer deletedAt;
}
