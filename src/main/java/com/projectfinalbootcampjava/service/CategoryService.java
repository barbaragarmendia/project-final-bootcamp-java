package com.projectfinalbootcampjava.service;

import com.projectfinalbootcampjava.domain.model.Category;

public interface CategoryService {
    Category findOrCreateCategory(String categoryName);
}
