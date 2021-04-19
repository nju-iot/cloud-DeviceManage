package com.lot.equipment.common;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Page extends ArrayList {

    private Integer offset;
    private Integer limit;
    private Integer totalSize;

}
