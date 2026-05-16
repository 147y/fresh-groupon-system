package com.fresh.freshgrouponsystem.controller;

import com.fresh.freshgrouponsystem.common.Result;
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
    public Result<Product> getProductById(@PathVariable Long id) {
        if (productService.getProductById(id) == null){
            return Result.error("商品不存在");
        }
        return Result.success("查询商品成功", productService.getProductById(id));
    }

    @GetMapping
    public Result<List<Product>> getAllProducts() {
        return Result.success("查询所有商品成功", productService.getAllProducts());
    }

    @GetMapping("/search")
    public Result<List<Product>> getProductsByName(@RequestParam String name) {
        return Result.success("查询商品成功", productService.getProductsByName(name));
    }

    @GetMapping("/page")
    public Result<PageInfo<Product>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> list = productService.getAllProducts();
        return Result.success(new PageInfo<>(list));
    }

    @PostMapping
    public Result<Integer> addProduct(@RequestBody Product product){
        return Result.success("添加商品成功", productService.addProduct(product));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteProduct(@PathVariable Long id) {
        return Result.success("删除商品成功", productService.deleteProduct(id));
    }

    @PutMapping
    public Result<Integer> updateProduct(@RequestBody Product product) {
        return Result.success("更新商品成功", productService.updateProduct(product));
    }
}
