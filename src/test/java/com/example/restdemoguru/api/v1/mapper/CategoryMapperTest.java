package com.example.restdemoguru.api.v1.mapper;

import com.example.restdemoguru.api.v1.model.CategoryDTO;
import com.example.restdemoguru.domain.Category;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryMapperTest {

    public static final String NAME = "Wacek";
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception {

        //given

        Category category = new Category();
        category.setName(NAME);
        category.setId(1L);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then

        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());



    }
}