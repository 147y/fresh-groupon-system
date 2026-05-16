package com.fresh.freshgrouponsystem.mapper;

import com.fresh.freshgrouponsystem.entity.UserAddress;

import java.util.List;

public interface UserAddressMapper {

    int insertAddress(UserAddress userAddress);
    int updateAddress(UserAddress userAddress);
    int deleteAddress(Long id);
    List<UserAddress> selectAddressesByUserId(Long userId);
    UserAddress selectAddressById(Long id);

}
