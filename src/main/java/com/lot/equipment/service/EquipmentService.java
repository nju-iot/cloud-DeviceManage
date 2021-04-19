package com.lot.equipment.service;

import com.lot.equipment.domain.Equipment;

/**
 * 设备信息接口
 */
public interface EquipmentService {

    /**
     * 添加设备基本信息
     * @param equipment
     */
    void add(Equipment equipment);

    /**
     * 更新设备信息
     * @param equipment
     */
    void update(Equipment equipment);

    /**
     * 删除设备信息
     * @param id
     */
    void delete(String id);

    /**
     * 根据设备ID获取设备信息
     * @param id
     * @return
     */
    Equipment getByEquipmentId(String id);
}
