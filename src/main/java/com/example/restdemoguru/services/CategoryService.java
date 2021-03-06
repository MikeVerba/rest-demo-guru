package com.example.restdemoguru.services;


import com.example.restdemoguru.api.v1.model.CategoryDTO;


import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
