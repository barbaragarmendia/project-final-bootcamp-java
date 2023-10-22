package com.projectfinalbootcampjava.service.impl;

import com.projectfinalbootcampjava.domain.model.Product;
import com.projectfinalbootcampjava.domain.model.Category;
import com.projectfinalbootcampjava.domain.repository.ProductRepository;
import com.projectfinalbootcampjava.service.CategoryService;
import com.projectfinalbootcampjava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Product create(Product product) {
        Category category = categoryService.findOrCreateCategory(product.getCategory().getName());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Category category = categoryService.findOrCreateCategory(product.getCategory().getName());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(category);
        return productRepository.save(existingProduct);
    }

    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}
