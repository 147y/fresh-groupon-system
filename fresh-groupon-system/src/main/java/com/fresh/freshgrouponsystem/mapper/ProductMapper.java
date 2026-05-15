package com.fresh.freshgrouponsystem.mapper;

import com.fresh.freshgrouponsystem.entity.Product;
import com.fresh.freshgrouponsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product getProductById(Long id);
    int insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String name);
}
