package com.lot.equipment.service;

import com.lot.equipment.domain.EquipmentScrap;

/**
 * 设备报废接口
 */
public interface EquipmentScrapService {

    /**
     * 设备报废记录
     * @param equipmentScrap
     */
    void add(EquipmentScrap equipmentScrap);

    /**
     * 删除设备报废记录
     * @param id
     */
    void delete(String id);

}
