package com.example.restdemoguru.controllers.v1;

import com.example.restdemoguru.api.v1.model.CustomerDTO;
import com.example.restdemoguru.services.CustomerService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    public static final String FIRSTNAME = "Wacek";
    public static final String LASTNAME = "Bolec";

    @Mock
    CustomerService customerService;


    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getAllCustomers() throws Exception {

        //given
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setFirstname(FIRSTNAME);
        customerDTO1.setLastname(LASTNAME);
        customerDTO1.setId(1L);

        CustomerDTO customerDTO2 = new CustomerDTO();
        customerDTO1.setFirstname("Jan");
        customerDTO1.setLastname("Morda");
        customerDTO1.setId(2L);

        List<CustomerDTO> customerDTOS = Arrays.asList(customerDTO1,customerDTO2);

        //when
        when(customerService.getAllCustomers()).thenReturn(customerDTOS);

        //then

        mockMvc.perform(get("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", Matchers.hasSize(2)));




    }

    @Test
    public void getCustomerById() throws Exception {

        //given

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(FIRSTNAME);
        customerDTO.setLastname(LASTNAME);
        customerDTO.setId(1L);

        //when

        when(customerService.getCustomerById(anyLong())).thenReturn(customerDTO);

        //then

        mockMvc.perform(get("/api/v1/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname",equalTo(FIRSTNAME))
        );


    }
}