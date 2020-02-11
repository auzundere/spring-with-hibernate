package com.longcreek.springboot.service;

import com.longcreek.springboot.model.User;

import java.util.List;

public interface UserService {

    User createProduct(User product);
    User updateProduct(User product);
    List<User> getAllProducts();
    User getProductById(Long productId);
    void deleteProduct(Long productId);
}
