package com.fresh.freshgrouponsystem.service.impl;

import com.fresh.freshgrouponsystem.entity.Product;
import com.fresh.freshgrouponsystem.entity.User;
import com.fresh.freshgrouponsystem.mapper.ProductMapper;
import com.fresh.freshgrouponsystem.mapper.UserMapper;
import com.fresh.freshgrouponsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(Long id) {
        return productMapper.getProductById(id);
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public int deleteProduct(Long id) {
        return productMapper.deleteProduct(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return productMapper.getProductsByName(productName);
    }
}
