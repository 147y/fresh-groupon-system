package com.fresh.freshgrouponsystem.service;

import com.fresh.freshgrouponsystem.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    int addUser(User user);
    int deleteUser(Long id);
    int updateUser(User user);
    List<User> getAllUsers();
    List<User> getUsersByName(String username);
}
