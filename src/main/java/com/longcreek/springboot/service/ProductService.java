package com.longcreek.springboot.service;

import com.longcreek.springboot.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    void deleteProduct(Long productId);
}
