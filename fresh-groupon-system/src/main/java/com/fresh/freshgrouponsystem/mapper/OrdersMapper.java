package com.fresh.freshgrouponsystem.mapper;

import com.fresh.freshgrouponsystem.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {

    Orders getOrderById(Long id);
    int insertOrder(Orders order);
    int updateOrder(Orders order);
    int deleteOrder(Long id);
    List<Orders> getAllOrders();
    List<Orders> getOrdersByUserId(Long userId);

}
