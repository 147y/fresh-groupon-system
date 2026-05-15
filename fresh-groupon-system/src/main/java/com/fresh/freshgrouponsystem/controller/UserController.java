package com.fresh.freshgrouponsystem.controller;

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
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public List<User> getUsersByName(@RequestParam String username) {
        return userService.getUsersByName(username);
    }

    @GetMapping("/page")
    public PageInfo<User> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.getAllUsers();
        return new PageInfo<>(list);
    }

    @PostMapping
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
