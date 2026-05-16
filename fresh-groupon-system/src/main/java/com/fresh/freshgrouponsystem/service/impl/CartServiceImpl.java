package com.fresh.freshgrouponsystem.service.impl;

import com.fresh.freshgrouponsystem.entity.Cart;
import com.fresh.freshgrouponsystem.mapper.CartMapper;
import com.fresh.freshgrouponsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public int addCart(Cart cart) {
        Cart tempCart = cartMapper.getCartByUserIdAndProductId(cart.getUserId(), cart.getProductId());
        if (tempCart != null) {
            tempCart.setQuantity(cart.getQuantity() + tempCart.getQuantity());
            return cartMapper.updateCart(tempCart);
        }else {
            return cartMapper.insertCart(cart);
        }
    }

    @Override
    public int deleteCart(Long id) {
        return cartMapper.deleteCart(id);
    }

    @Override
    public int updateCart(Cart cart) {
        if(cart.getQuantity() <= 0) {
            return cartMapper.deleteCart(cart.getId());
        }
        return cartMapper.updateCart(cart);
    }

    @Override
    public List<Cart> getCartByUserId(Long userId) {
        return cartMapper.getCartByUserId(userId);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartMapper.getCartById(id);
    }
}
