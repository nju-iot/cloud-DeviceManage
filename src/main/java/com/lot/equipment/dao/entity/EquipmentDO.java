package com.lot.equipment.dao.entity;

import lombok.Data;

@Data
public class EquipmentDO {

    /**
     * 设备ID
     */
    private String id;
    /**
     * 设备名
     */
    private String name;
    private String code;
    private String type;
    private String department;
    private String brand;
    private String sn;
    private Integer status;
    private Integer inboundAt;
    private Integer registrationAt;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer createdAt;
    private Integer updatedAt;
    private Integer deletedAt;
}
