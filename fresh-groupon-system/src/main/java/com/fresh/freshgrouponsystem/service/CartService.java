package com.fresh.freshgrouponsystem.service;

import com.fresh.freshgrouponsystem.entity.Cart;

import java.util.List;

public interface CartService {

    int addCart(Cart cart);
    int deleteCart(Long id);
    int updateCart(Cart cart);
    List<Cart> getCartByUserId(Long userId);
    Cart getCartById(Long id);
}
