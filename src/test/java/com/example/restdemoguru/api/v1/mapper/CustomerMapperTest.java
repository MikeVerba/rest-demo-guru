package com.example.restdemoguru.api.v1.mapper;

import com.example.restdemoguru.api.v1.model.CategoryDTO;
import com.example.restdemoguru.api.v1.model.CustomerDTO;
import com.example.restdemoguru.domain.Customer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerMapperTest {

    private static final String FIRSTNAME = "Wacek";
    private static final String LASTNAME = "Mucha";

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception{

        //given

        Customer customer = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);
        customer.setId(1L);

        //when

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);


        //then

        assertEquals(FIRSTNAME,customerDTO.getFirstname());
        assertEquals(LASTNAME,customerDTO.getLastname());

    }

}