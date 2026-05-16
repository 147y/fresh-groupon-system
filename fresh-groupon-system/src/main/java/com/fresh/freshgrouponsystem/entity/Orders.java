package com.fresh.freshgrouponsystem.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Orders {
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal totalPrice;
    private Integer status;
    private Date createTime;
    private Integer isDeleted = 0;
}
