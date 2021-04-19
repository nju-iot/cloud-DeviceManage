package com.lot.equipment.controller;

import com.lot.equipment.common.Response;
import com.lot.equipment.common.enums.CommonErrorCode;
import com.lot.equipment.common.tools.AssertUtil;
import com.lot.equipment.domain.EquipmentScrap;
import com.lot.equipment.service.EquipmentScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 设备报废Controlller
 */
@RestController
@RequestMapping("/v1/equipmentScrap")
public class EquipmentScrapController {

    @Autowired
    private EquipmentScrapService equipmentScrapService;

    /**
     * 添加设备报废记录
     * @param equipmentScrap
     * @return
     */
    @PostMapping("/add")
    private Response add(@RequestBody EquipmentScrap equipmentScrap) {
        AssertUtil.isNotBlank(equipmentScrap.getEquipmentId(), CommonErrorCode.EUIPMENT_ID_EMPTY);
        AssertUtil.isNotBlank(equipmentScrap.getReason(), CommonErrorCode.REASON_EMPTY);
        equipmentScrapService.add(equipmentScrap);
        return Response.succ();
    }

    /**
     * 删除设备报废记录
     * @param id
     * @return
     */
    @PostMapping("/delete")
    private Response delete(String id) {
        equipmentScrapService.delete(id);
        return Response.succ();
    }
}
