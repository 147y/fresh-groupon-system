package com.fresh.freshgrouponsystem.service.impl;

import com.fresh.freshgrouponsystem.entity.OrderItem;
import com.fresh.freshgrouponsystem.mapper.OrderItemMapper;
import com.fresh.freshgrouponsystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int addOrderItem(OrderItem orderItem) {
        return orderItemMapper.addOrderItem(orderItem);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemMapper.getOrderItemsByOrderId(orderId);
    }
}
