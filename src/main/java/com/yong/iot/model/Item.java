package com.yong.iot.model;

import lombok.Data;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 */

@Data
public class Item {
    private String id,text;
    private boolean isActive,isChecked;
    private int value;

}