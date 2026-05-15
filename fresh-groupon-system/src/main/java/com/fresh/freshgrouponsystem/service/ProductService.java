package com.fresh.freshgrouponsystem.service;

import com.fresh.freshgrouponsystem.entity.Product;
import com.fresh.freshgrouponsystem.entity.User;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);
    int addProduct(Product product);
    int deleteProduct(Long id);
    int updateProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String name);
}
