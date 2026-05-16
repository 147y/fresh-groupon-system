package com.fresh.freshgrouponsystem.controller;

import com.fresh.freshgrouponsystem.common.Result;
import com.fresh.freshgrouponsystem.entity.User;
import com.fresh.freshgrouponsystem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        if (userService.getUserById(id) == null){
            return Result.error("用户不存在");
        }
        return Result.success("查询用户成功", userService.getUserById(id));
    }

    @GetMapping
    public Result<List<User>> getAllUsers() {
        return Result.success("查询所有用户成功", userService.getAllUsers());
    }

    @GetMapping("/search")
    public Result<List<User>> getUsersByName(@RequestParam String username) {
        return Result.success("查询用户成功", userService.getUsersByName(username));
    }

    @GetMapping("/page")
    public Result<PageInfo<User>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.getAllUsers();
        return Result.success(new PageInfo<>(list));
    }

    @PostMapping
    public Result<Integer> addUser(@RequestBody User user){
        return Result.success("添加用户成功", userService.addUser(user));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteUser(@PathVariable Long id) {
        return Result.success("删除用户成功", userService.deleteUser(id));
    }

    @PutMapping
    public Result<Integer> updateUser(@RequestBody User user) {
        return Result.success("更新用户成功", userService.updateUser(user));
    }

}
