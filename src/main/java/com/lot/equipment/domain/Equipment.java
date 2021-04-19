package com.lot.equipment.domain;

import lombok.Data;

/**
 * 设备信息
 */
@Data
public class Equipment {

    /**
     * 设备ID
     */
    private String id;
    /**
     * 设备名
     */
    private String name;
    /**
     * 设备编码
     */
    private String code;
    /**
     * 设备类型
     */
    private String type;
    /**
     * 设备部门
     */
    private String department;
    /**
     * 设备品牌
     */
    private String brand;
    /**
     * 设备唯一编码
     */
    private String sn;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 设备入库时间
     */
    private Integer inboundAt;
    /**
     * 设备注册时间
     */
    private Integer registrationAt;

    /**
     * 添加人
     */
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer createdAt;
    private Integer updatedAt;
    private Integer deletedAt;
}
