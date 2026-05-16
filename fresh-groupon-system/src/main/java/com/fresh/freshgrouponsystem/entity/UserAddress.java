package com.fresh.freshgrouponsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserAddress {
    private Long id;
    private Long userId;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private Integer isDefault;
    private Date createTime;
    private Integer isDeleted = 0;
}
