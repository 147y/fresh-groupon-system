package com.fresh.freshgrouponsystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private List<Long> cartIdList;
    private Long addressId;
}
