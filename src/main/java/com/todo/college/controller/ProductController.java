package com.todo.college.controller;

import com.todo.college.model.Product;
import com.todo.college.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private productService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/allData")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/get/{id}")

    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        return productService.deleteProductById(id);
    }
}