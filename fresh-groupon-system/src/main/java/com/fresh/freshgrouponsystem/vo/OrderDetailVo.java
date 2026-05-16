package com.fresh.freshgrouponsystem.vo;

import com.fresh.freshgrouponsystem.entity.OrderItem;
import com.fresh.freshgrouponsystem.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailVo {
    private Orders order;
    private List<OrderItem> itemList;
}
