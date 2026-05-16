package com.fresh.freshgrouponsystem.controller;

import com.fresh.freshgrouponsystem.common.Result;
import com.fresh.freshgrouponsystem.entity.UserAddress;
import com.fresh.freshgrouponsystem.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @PostMapping
    public Result<Integer> addAddress(@RequestBody UserAddress userAddress) {
        return Result.success("地址增加成功",userAddressService.addAddress(userAddress));
    }

    @PutMapping
    public Result<Integer> updateAddress(@RequestBody UserAddress userAddress) {
        return Result.success("地址更新成功",userAddressService.updateAddress(userAddress));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteAddress(@PathVariable Long id) {
        return Result.success("地址删除成功",userAddressService.deleteAddress(id));
    }

    @GetMapping("/user/{userId}")
    public Result<List<UserAddress>> getAddressByUserId(@PathVariable Long userId) {
        return Result.success("获取地址成功",userAddressService.getAddressByUserId(userId));
    }

    @GetMapping("/{id}")
    public Result<UserAddress> getAddressById(@PathVariable Long id) {
        return Result.success("获取地址成功",userAddressService.getAddressById(id));
    }
}
