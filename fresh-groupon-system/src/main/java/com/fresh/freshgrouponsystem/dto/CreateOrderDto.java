package com.fresh.freshgrouponsystem.dto;

import com.fresh.freshgrouponsystem.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {
    private Long userId;
    private List<OrderItem> items;
}
