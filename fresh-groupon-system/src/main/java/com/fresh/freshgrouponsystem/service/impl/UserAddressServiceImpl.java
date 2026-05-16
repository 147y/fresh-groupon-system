package com.fresh.freshgrouponsystem.service.impl;

import com.fresh.freshgrouponsystem.entity.UserAddress;
import com.fresh.freshgrouponsystem.mapper.UserAddressMapper;
import com.fresh.freshgrouponsystem.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public int addAddress(UserAddress userAddress) {
        return userAddressMapper.insertAddress(userAddress);
    }

    @Override
    public int updateAddress(UserAddress userAddress) {
        return userAddressMapper.updateAddress(userAddress);
    }

    @Override
    public int deleteAddress(Long id) {
        return userAddressMapper.deleteAddress(id);
    }

    @Override
    public List<UserAddress> getAddressByUserId(Long userId) {
        return userAddressMapper.selectAddressesByUserId(userId);
    }

    @Override
    public UserAddress getAddressById(Long id) {
        return userAddressMapper.selectAddressById(id);
    }
}
