package com.lot.equipment.service.impl;

import com.lot.equipment.common.SessionLocal;
import com.lot.equipment.common.enums.EquipmentScrapStatus;
import com.lot.equipment.common.tools.DateTimeUtil;
import com.lot.equipment.dao.EquipmentMapper;
import com.lot.equipment.dao.EquipmentScrapMapper;
import com.lot.equipment.dao.entity.EquipmentDO;
import com.lot.equipment.dao.entity.EquipmentScrapDO;
import com.lot.equipment.domain.EquipmentScrap;
import com.lot.equipment.service.EquipmentScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 设备报废接口实现类
 */
@Service
public class EquipmentScrapServiceImpl implements EquipmentScrapService {

    @Autowired
    private EquipmentScrapMapper equipmentScrapMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public void add(EquipmentScrap equipmentScrap) {

        // 校验设备ID是否存在
        EquipmentDO existing = equipmentMapper.getById(equipmentScrap.getEquipmentId());
        if (existing == null) {
            throw new IllegalStateException("设备ID:" + equipmentScrap.getEquipmentId() + " 不存在");
        }

        // 校验设备报废记录ID是否存在
        EquipmentScrapDO exstingScrap = equipmentScrapMapper.getByEquipmentId(equipmentScrap.getEquipmentId());
        if (exstingScrap == null) {
            throw new IllegalStateException("设备已报废过");
        }

        // 数据初始化
        equipmentScrap.setCreatedBy(SessionLocal.getPrincipal().getUserName());
        equipmentScrap.setCreatedAt(DateTimeUtil.now());
        equipmentScrap.setStatus(EquipmentScrapStatus.NORMAL.getCode());
        // 对象转换为DO
        EquipmentScrapDO equipmentScrapDO = convert(equipmentScrap);
        // 设备报废数据库插入
        equipmentScrapMapper.insert(equipmentScrapDO);
    }


    @Override
    public void delete(String id) {

        // 校验设备报废记录ID是否存在
        EquipmentScrapDO equipmentScrapDO = equipmentScrapMapper.getByEquipmentId(id);
        if (equipmentScrapDO == null) {
            throw new IllegalStateException("设备报废 equipmentScrapId:" + id + " 不存在");
        }

        // 更新设备报废状态删除
        EquipmentScrapDO update = new EquipmentScrapDO();
        update.setId(id);
        update.setStatus(EquipmentScrapStatus.DELETED.getCode());
        equipmentScrapMapper.update(update);
    }


    private EquipmentScrapDO convert(EquipmentScrap s) {
        EquipmentScrapDO d = new EquipmentScrapDO();
        d.setEquipmentId(s.getEquipmentId());
        d.setReason(s.getReason());
        d.setType(s.getType());
        d.setStatus(s.getStatus());
        d.setUpdatedAt(s.getUpdatedAt());
        d.setUpdatedBy(s.getUpdatedBy());
        d.setCreatedAt(s.getCreatedAt());
        d.setCreatedBy(s.getCreatedBy());
        s.setDeletedAt(s.getCreatedAt());
        s.setDeletedBy(s.getCreatedBy());
        return d;
    }

}
