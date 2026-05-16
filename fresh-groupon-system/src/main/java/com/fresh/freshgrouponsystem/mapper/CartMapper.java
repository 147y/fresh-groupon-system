package com.fresh.freshgrouponsystem.mapper;

import com.fresh.freshgrouponsystem.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    int insertCart(Cart cart);
    int deleteCart(Long id);
    int updateCart(Cart cart);
    List<Cart> getCartByUserId(Long userId);
    Cart getCartById(Long id);
    Cart getCartByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

    List<Cart> selectByIds(@Param("ids") List<Long> ids);
    int deleteByIds(@Param("ids") List<Long> ids);
}
