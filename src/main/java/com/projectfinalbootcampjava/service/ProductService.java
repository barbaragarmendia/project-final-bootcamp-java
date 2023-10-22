package com.projectfinalbootcampjava.service;

import com.projectfinalbootcampjava.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getProductById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    void delete(Long productId);
}
