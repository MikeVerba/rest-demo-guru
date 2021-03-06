package com.example.restdemoguru.controllers.v1;

import com.example.restdemoguru.api.v1.model.CategoryDTO;
import com.example.restdemoguru.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.yaml.snakeyaml.events.Event;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

    public static final String NAME = "Jim";

    @Mock
    CategoryService categoryService;


    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }


    @Test
    public void testListCategories() throws Exception {

        //given

        CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setName(NAME);
        categoryDTO1.setId(1L);

        CategoryDTO categoryDTO2 = new CategoryDTO();
        categoryDTO2.setName("Wacek");
        categoryDTO2.setId(2L);

        List<CategoryDTO> categoryDTOS = Arrays.asList(categoryDTO1,categoryDTO2);

        //when

        when(categoryService.getAllCategories()).thenReturn(categoryDTOS);


        //then

        mockMvc.perform(get("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories",hasSize(2)));

    }

    @Test
    public void testGetByNameCategories() throws Exception {

        //given
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(NAME);
        categoryDTO.setId(1L);
        //when
        when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDTO);

        //then

        mockMvc.perform(get("/api/v1/categories/Jim")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",equalTo(NAME)));

    }











}