package com.fresh.freshgrouponsystem.service;

import com.fresh.freshgrouponsystem.dto.CartDto;
import com.fresh.freshgrouponsystem.dto.CreateOrderDto;
import com.fresh.freshgrouponsystem.entity.Orders;
import com.fresh.freshgrouponsystem.vo.OrderDetailVo;

import java.util.List;

public interface OrdersService {

    Orders getOrderById(Long id);
    int addOrder(Orders order);
    int updateOrder(Orders order);
    int deleteOrder(Long id);
    List<Orders> getAllOrders();
    List<Orders> getOrdersByUserId(Long userId);
    int createOrder(CreateOrderDto dto);

    OrderDetailVo getOrderDetail(Long orderId);
    int createOrderByCart(CartDto dto);
}
