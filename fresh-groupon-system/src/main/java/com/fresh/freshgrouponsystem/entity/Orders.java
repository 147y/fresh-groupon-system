package com.fresh.freshgrouponsystem.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Orders {
    private Long id;
    private String orderNo;
    private Long userId;
    private Integer status;
    private Date createTime;
    private Integer isDelete;
}
