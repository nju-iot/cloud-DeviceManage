package com.lot.equipment.dao.condition;

import lombok.Data;

@Data
public class EquipmentScrapCondition {

    private String name;
    private String code;
    private Integer startTime;
    private Integer endTime;
    private Integer status;
    private Integer offset;
    private Integer limit;
}
