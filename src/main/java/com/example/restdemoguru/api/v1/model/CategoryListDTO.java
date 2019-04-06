package com.example.restdemoguru.api.v1.model;


import lombok.Data;

import java.util.List;

@Data
public class CategoryListDTO {
    List<CategoryDTO> categories;

    public CategoryListDTO(List<CategoryDTO> allCategories) {
        this.categories = allCategories;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
