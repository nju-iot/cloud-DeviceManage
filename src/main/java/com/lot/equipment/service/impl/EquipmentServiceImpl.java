package com.lot.equipment.service.impl;

import com.lot.equipment.common.cache.CacheFactory;
import com.lot.equipment.common.cache.CacheType;
import com.lot.equipment.common.cache.DataLoader;
import com.lot.equipment.common.enums.EquipmentStatus;
import com.lot.equipment.dao.EquipmentMapper;
import com.lot.equipment.dao.entity.EquipmentDO;
import com.lot.equipment.domain.Equipment;
import com.lot.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 设备信息接口实现类
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    /**
     * 设备缓存KEy
     */
    private static final String CACHE_KEY = "equipment:info:";

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public void add(Equipment equipment) {
        // 转换成DO对象
        EquipmentDO equipmentDO = convert(equipment);
        // Mapper插入数据库
        equipmentMapper.insert(equipmentDO);
    }

    @Override
    public void update(Equipment equipment) {

        // 校验设备ID是否存在
        EquipmentDO existing = equipmentMapper.getById(equipment.getId());
        if (existing == null) {
            throw new IllegalStateException("equipmentId:" + equipment.getId() + " 不存在");
        }

        // 转换DO对象
        EquipmentDO equipmentDO = convert(equipment);
        // Mapper更新数据库
        equipmentMapper.update(equipmentDO);
        // 释放缓存
        CacheFactory.getCache(CacheType.REDIS).release(CACHE_KEY + equipment.getId());

    }

    @Override
    public void delete(String id) {

        // 校验设备ID是否存在
        EquipmentDO equipmentDO = equipmentMapper.getById(id);
        if (equipmentDO == null) {
            throw new IllegalStateException("equipmentId:" + id + " 不存在");
        }

        // 构建设备更新DO对象
        EquipmentDO update = new EquipmentDO();
        update.setId(id);
        // 设置设备状态为删除，进行逻辑删除，不直接删除数据库数据
        update.setStatus(EquipmentStatus.DELETED.getCode());
        // Mapper更新数据库
        equipmentMapper.update(update);
        // 释放缓存
        CacheFactory.getCache(CacheType.REDIS).release(CACHE_KEY + id);
    }

    @Override
    public Equipment getByEquipmentId(String id) {

        // 从数据库加载设备信息，并缓存起来
        return CacheFactory.getCache(CacheType.REDIS).get(new DataLoader<Equipment>() {

            @Override
            public String key() {
                return CACHE_KEY + id;
            }

            @Override
            public Equipment load() {
                // 根据ID 查询数据库
                EquipmentDO equipmentDO = equipmentMapper.getById(id);
                if (equipmentDO == null) {
                    throw new IllegalStateException("equipmentId:" + id + " 不存在");
                }
                // 转换DO对象为Domain
                Equipment equipment = convert(equipmentDO);
                return equipment;
            }

            @Override
            public Class<Equipment> dataType() {
                return Equipment.class;
            }
        });
    }

    /**
     * 转换对象为DO对象
     *
     * @param s
     * @return
     */
    private EquipmentDO convert(Equipment s) {
        EquipmentDO d = new EquipmentDO();
        d.setBrand(s.getBrand());
        d.setCode(s.getCode());
        d.setCreatedAt(s.getCreatedAt());
        d.setDeletedAt(s.getDeletedAt());
        d.setCreatedBy(s.getCreatedBy());
        d.setDeletedBy(s.getCreatedBy());
        d.setDepartment(s.getDepartment());
        d.setId(s.getId());
        d.setInboundAt(s.getInboundAt());
        d.setName(s.getName());
        d.setRegistrationAt(s.getRegistrationAt());
        d.setSn(s.getSn());
        d.setStatus(s.getStatus());
        d.setType(s.getType());
        d.setUpdatedAt(s.getUpdatedAt());
        d.setUpdatedBy(s.getUpdatedBy());
        return d;
    }

    /**
     * 转换DO对象为Domain
     *
     * @param s
     * @return
     */
    private Equipment convert(EquipmentDO s) {
        Equipment d = new Equipment();
        d.setBrand(s.getBrand());
        d.setCode(s.getCode());
        d.setCreatedAt(s.getCreatedAt());
        d.setDeletedAt(s.getDeletedAt());
        d.setCreatedBy(s.getCreatedBy());
        d.setDeletedBy(s.getCreatedBy());
        d.setDepartment(s.getDepartment());
        d.setId(s.getId());
        d.setInboundAt(s.getInboundAt());
        d.setName(s.getName());
        d.setRegistrationAt(s.getRegistrationAt());
        d.setSn(s.getSn());
        d.setStatus(s.getStatus());
        d.setType(s.getType());
        d.setUpdatedAt(s.getUpdatedAt());
        d.setUpdatedBy(s.getUpdatedBy());
        return d;
    }
}
