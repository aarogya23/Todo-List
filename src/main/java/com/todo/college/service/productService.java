package com.todo.college.service;

import com.todo.college.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService {

    private List<Product> products = new ArrayList<>();
    private long counter = 1L;

    public String addProduct(Product product) {

        if (product == null) {
            return "Product is null";
        }

        product.setId(counter++);
        products.add(product);

        return product.getName() + " is added to the array.";
    }

    public List<Product> getProducts() {
        return products;
    }


    public Product getProductById(String id ) {
        for (Product product : products) {

            if(product.getId().equals(id)) {
                return product;
            }

        }
        return null;
    }

    public String deleteProductById(String id) {
        for (Product product : products) {
            if(product.getId().equals(id)) {
                products.remove(product);
                return product.getName() + " is deleted from the array.";
            }
        }
        return "Failed to delete.";
    }
}