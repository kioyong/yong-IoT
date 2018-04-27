package com.yong.iot.model;

import lombok.Data;

import java.util.Date;

/**
 * @author LiangYong
 * @date 2017/12/24
 */
@Data
public abstract class BaseEntity implements HasId {

    private String CreatedBy,LastModifiedBy;
    private Date CreatedDate,LastModifiedDate;

}
