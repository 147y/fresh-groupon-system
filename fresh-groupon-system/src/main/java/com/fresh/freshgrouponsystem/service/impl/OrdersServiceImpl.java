package com.fresh.freshgrouponsystem.service.impl;

import com.fresh.freshgrouponsystem.dto.CartDto;
import com.fresh.freshgrouponsystem.dto.CreateOrderDto;
import com.fresh.freshgrouponsystem.entity.Cart;
import com.fresh.freshgrouponsystem.entity.OrderItem;
import com.fresh.freshgrouponsystem.entity.Orders;
import com.fresh.freshgrouponsystem.entity.Product;
import com.fresh.freshgrouponsystem.mapper.CartMapper;
import com.fresh.freshgrouponsystem.mapper.OrderItemMapper;
import com.fresh.freshgrouponsystem.mapper.OrdersMapper;
import com.fresh.freshgrouponsystem.mapper.ProductMapper;
import com.fresh.freshgrouponsystem.service.OrdersService;
import com.fresh.freshgrouponsystem.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Orders getOrderById(Long id) {
        return ordersMapper.getOrderById(id);
    }

    @Override
    public int addOrder(Orders order) {
        return ordersMapper.insertOrder(order);
    }

    @Override
    public int updateOrder(Orders order) {
        return ordersMapper.updateOrder(order);
    }

    @Override
    public int deleteOrder(Long id) {
        return ordersMapper.deleteOrder(id);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersMapper.getAllOrders();
    }

    @Override
    public List<Orders> getOrdersByUserId(Long userId) {
        return ordersMapper.getOrdersByUserId(userId);
    }

    @Transactional
    @Override
    public int createOrder(CreateOrderDto dto) {
        Long userId = dto.getUserId();
        List<OrderItem> items = dto.getItems();
        BigDecimal totalPrice = new BigDecimal("0");
        for (int i = 0; i < items.size(); i++) {
            BigDecimal price = items.get(i).getProductPrice();
            BigDecimal quantity = new BigDecimal(items.get(i).getQuantity());
            BigDecimal itemTotalPrice = price.multiply(quantity);
            totalPrice = totalPrice.add(itemTotalPrice);
        }
        String orderNo = "Order" + System.currentTimeMillis();
        Orders order = new Orders();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setTotalPrice(totalPrice);
        order.setStatus(0);
        ordersMapper.insertOrder(order);
        for (int j = 0; j < items.size(); j++) {
            OrderItem item = items.get(j);
            item.setOrderId(order.getId());
            orderItemMapper.addOrderItem(item);
        }
        return order.getId().intValue();
    }

    @Override
    public OrderDetailVo getOrderDetail(Long orderId) {
        Orders order = ordersMapper.getOrderById(orderId);
        if (order == null) {
            throw new RuntimeException("订单不存在");
        }
        List<OrderItem> itemList = orderItemMapper.getOrderItemsByOrderId(orderId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setItemList(itemList);
        return vo;
    }

    @Transactional
    @Override
    public int createOrderByCart(CartDto dto) {
        List<Long> cartIdList = dto.getCartIdList();
        List<Cart> cartList = cartMapper.selectByIds(cartIdList);
        if (cartList == null || cartList.isEmpty()){
            throw new RuntimeException("未选择购物车内商品");
        }
        Long userId = cartList.get(0).getUserId();
        BigDecimal totalPrice = new BigDecimal("0");
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
            Product product = productMapper.getProductById(cart.getProductId());
            if(product == null) {
                throw new RuntimeException("商品不存在");
            }
            BigDecimal price = product.getPrice();
            Integer quantity = cart.getQuantity();
            BigDecimal itemTotal = price.multiply(new BigDecimal(quantity));
            totalPrice = totalPrice.add(itemTotal);
            OrderItem item = new OrderItem();
            item.setProductId(product.getId());
            item.setProductName(product.getName());
            item.setProductPrice(price);
            item.setQuantity(quantity);
            orderItemList.add(item);
        }
        Orders order = new Orders();
        order.setOrderNo("Order" + System.currentTimeMillis());
        order.setUserId(userId);
        order.setAddressId(dto.getAddressId());
        order.setTotalPrice(totalPrice);
        order.setStatus(0);
        ordersMapper.insertOrder(order);
        for (int j = 0; j < orderItemList.size(); j++) {
            OrderItem item = orderItemList.get(j);
            item.setOrderId(order.getId());
            orderItemMapper.addOrderItem(item);
        }
        cartMapper.deleteByIds(cartIdList);
        return order.getId().intValue();
    }
}
