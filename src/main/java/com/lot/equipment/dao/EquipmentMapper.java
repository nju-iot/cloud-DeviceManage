package com.lot.equipment.dao;

import com.lot.equipment.dao.condition.EquipmentCondition;
import com.lot.equipment.dao.entity.EquipmentDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMapper {

    int insert(EquipmentDO record);

    void update(EquipmentDO record);

    EquipmentDO getById(String id);

    List<EquipmentDO> listBy(EquipmentCondition condition);

}
