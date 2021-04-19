package com.lot.equipment.dao;

import com.lot.equipment.dao.entity.EquipmentScrapDO;
import com.lot.equipment.dao.condition.EquipmentScrapCondition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentScrapMapper {

    int insert(EquipmentScrapDO record);

    void update(EquipmentScrapDO record);

    EquipmentScrapDO getByEquipmentId(String equipmentId);

    EquipmentScrapDO getById(String id);

    List<EquipmentScrapDO> listBy(EquipmentScrapCondition condition);

}
