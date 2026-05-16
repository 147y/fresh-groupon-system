package com.fresh.freshgrouponsystem.service;

import com.fresh.freshgrouponsystem.entity.UserAddress;

import java.util.List;

public interface UserAddressService {

    int addAddress(UserAddress userAddress);
    int updateAddress(UserAddress userAddress);
    int deleteAddress(Long id);
    List<UserAddress> getAddressByUserId(Long userId);
    UserAddress getAddressById(Long id);
}
