package com.fresh.freshgrouponsystem.controller;

import com.fresh.freshgrouponsystem.entity.Product;
import com.fresh.freshgrouponsystem.entity.User;
import com.fresh.freshgrouponsystem.service.ProductService;
import com.fresh.freshgrouponsystem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/page")
    public PageInfo<Product> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> list = productService.getAllProducts();
        return new PageInfo<>(list);
    }

    @PostMapping
    public int addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping
    public int updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
