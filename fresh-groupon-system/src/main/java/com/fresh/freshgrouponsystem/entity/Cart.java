package com.fresh.freshgrouponsystem.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Cart {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Date createTime;
}
