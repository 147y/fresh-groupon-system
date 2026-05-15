package com.fresh.freshgrouponsystem.mapper;

import com.fresh.freshgrouponsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    User getUserById(Long id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Long id);
    List<User> getAllUsers();
    List<User> getUsersByName(String name);
}
