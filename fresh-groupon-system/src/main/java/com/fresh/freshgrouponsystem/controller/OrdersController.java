package com.fresh.freshgrouponsystem.controller;

import com.fresh.freshgrouponsystem.common.Result;
import com.fresh.freshgrouponsystem.dto.CartDto;
import com.fresh.freshgrouponsystem.dto.CreateOrderDto;
import com.fresh.freshgrouponsystem.entity.Orders;
import com.fresh.freshgrouponsystem.entity.User;
import com.fresh.freshgrouponsystem.service.OrdersService;
import com.fresh.freshgrouponsystem.vo.OrderDetailVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{id}")
    public Result<Orders> getOrderById(@PathVariable Long id) {
        if (ordersService.getOrderById(id) == null){
            return Result.error("订单不存在");
        }
        return Result.success("查询订单成功",ordersService.getOrderById(id));
    }

    @GetMapping
    public Result<List<Orders>> getAllOrders() {
        return Result.success("查询所有订单成功",ordersService.getAllOrders());
    }

    @GetMapping("/search")
    public Result<List<Orders>> getOrdersByUserId(@RequestParam Long userId) {
        return Result.success("查询用户订单成功",ordersService.getOrdersByUserId(userId));
    }

    @GetMapping("/page")
    public Result<PageInfo<Orders>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = ordersService.getAllOrders();
        return Result.success("查询分页订单成功",new PageInfo<>(list));
    }

    @GetMapping("/detail/{id}")
    public Result<OrderDetailVo> getOrderDetail(@PathVariable Long id) {
        return Result.success("查询订单详情成功",ordersService.getOrderDetail(id));
    }

    @PostMapping
    public Result<Integer> addOrder(@RequestBody Orders order){
        return Result.success("添加订单成功",ordersService.addOrder(order));
    }

    @PostMapping("/create")
    public Result<Integer> createOrder(@RequestBody CreateOrderDto dto){
        return Result.success("创建订单成功",ordersService.createOrder(dto));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteOrder(@PathVariable Long id){
        return Result.success("删除订单成功",ordersService.deleteOrder(id));
    }

    @PutMapping
    public Result<Integer> updateOrder(@RequestBody Orders order) {
        return Result.success("更新订单成功",ordersService.updateOrder(order));
    }

    @PostMapping("/createByCart")
    public Result<Integer> createOrderByCart(@RequestBody CartDto dto){
        return Result.success("创建订单成功",ordersService.createOrderByCart(dto));
    }
}
