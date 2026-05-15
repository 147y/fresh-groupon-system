package com.fresh.freshgrouponsystem.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;
    private Integer stock;
    private Integer status = 1;
    private Date createTime;
    private Integer isDeleted = 0;
}
