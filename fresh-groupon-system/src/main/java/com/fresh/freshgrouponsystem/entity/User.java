package com.fresh.freshgrouponsystem.entity;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private Date createTime;
    private Integer isDeleted = 0;
}
