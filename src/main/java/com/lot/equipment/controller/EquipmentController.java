package com.lot.equipment.controller;

import com.lot.equipment.common.Response;
import com.lot.equipment.common.enums.CommonErrorCode;
import com.lot.equipment.common.tools.AssertUtil;
import com.lot.equipment.domain.Equipment;
import com.lot.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 设备信息管理Controller
 */
@RestController
@RequestMapping("/v1/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 根据设备id获取信息
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    private Response info(@PathVariable String id) {
        Equipment equipment = equipmentService.getByEquipmentId(id);
        return Response.succ(equipment);
    }

    /**
     * 添加设备
     * @param equipment
     * @return
     */
    @PostMapping("/add")
    private Response add(@RequestBody Equipment equipment) {
        // 校验参数
        verifyAddParams(equipment);
        // 调用设备服务接口，新增设备
        equipmentService.add(equipment);
        return Response.succ();
    }

    /**
     *参数合法性校验
     * @param equipment
     */
    private void verifyAddParams(@RequestBody Equipment equipment) {
        AssertUtil.isNotBlank(equipment.getCode(), CommonErrorCode.CODE_EMPTY);
        AssertUtil.isNotBlank(equipment.getName(), CommonErrorCode.NAME_EMPTY);
    }

    /**
     * 更新设备信息
     * @param equipment
     * @return
     */
    @PostMapping("/update")
    private Response update(@RequestBody Equipment equipment) {

        // 设备ID校验
        AssertUtil.isNotBlank(equipment.getId(), CommonErrorCode.EUIPMENT_ID_EMPTY);
        // 更新设备信息
        equipmentService.update(equipment);
        return Response.succ();
    }

    /**
     * 删除设备
     * @param id
     * @return
     */
    @PostMapping("/delete")
    private Response delete(String id) {
        equipmentService.delete(id);
        return Response.succ();
    }
}
