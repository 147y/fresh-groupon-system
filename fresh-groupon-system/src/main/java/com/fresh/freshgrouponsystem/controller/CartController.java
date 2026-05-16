package com.fresh.freshgrouponsystem.controller;

import com.fresh.freshgrouponsystem.common.Result;
import com.fresh.freshgrouponsystem.entity.Cart;
import com.fresh.freshgrouponsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Result<Integer> addCart(@RequestBody Cart cart) {
        return Result.success("添加成功", cartService.addCart(cart));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteCart(@PathVariable Long id) {
        return Result.success("删除成功", cartService.deleteCart(id));
    }

    @PutMapping
    public Result<Integer> updateCart(@RequestBody Cart cart) {
        return Result.success("更新成功", cartService.updateCart(cart));
    }

    @GetMapping("/user/{userId}")
    public Result<List<Cart>> getCartByUserId(@PathVariable Long userId) {
        return Result.success("查询成功", cartService.getCartByUserId(userId));
    }

    @GetMapping("/{id}")
    public Result<Cart> getCartById(@PathVariable Long id) {
        return Result.success("查询成功", cartService.getCartById(id));
    }
}
