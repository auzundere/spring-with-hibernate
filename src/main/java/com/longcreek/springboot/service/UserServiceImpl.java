package com.longcreek.springboot.service;

import com.longcreek.springboot.exception.ResourceNotFoundException;
import com.longcreek.springboot.model.User;
import com.longcreek.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository productRepository;


    @Override
    public User createProduct(User product) {
        return productRepository.save(product);
    }

    @Override
    public User updateProduct(User product) {
        Optional<User> productDb = this.productRepository.findById(product.getId());

        if (productDb.isPresent()) {
            User productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setEmail(product.getEmail());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }

    @Override
    public List<User> getAllProducts() {
        return (List<User>) this.productRepository.findAll();
    }

    @Override
    public User getProductById(Long productId) {

        Optional<User> productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteProduct(Long productId) {

        Optional<User> productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            this.productRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }
}
