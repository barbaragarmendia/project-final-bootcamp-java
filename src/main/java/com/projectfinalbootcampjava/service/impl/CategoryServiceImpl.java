package com.projectfinalbootcampjava.service.impl;

import com.projectfinalbootcampjava.domain.model.Category;
import com.projectfinalbootcampjava.domain.repository.CategoryRepository;
import com.projectfinalbootcampjava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findOrCreateCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        if (category == null) {
            category = new Category();
            category.setName(categoryName);
            category = categoryRepository.save(category);
        }
        return category;
    }
}
