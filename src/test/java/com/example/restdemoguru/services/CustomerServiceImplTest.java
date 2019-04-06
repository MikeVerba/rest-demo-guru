package com.example.restdemoguru.services;

import com.example.restdemoguru.api.v1.mapper.CustomerMapper;
import com.example.restdemoguru.api.v1.model.CustomerDTO;
import com.example.restdemoguru.domain.Customer;
import com.example.restdemoguru.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {


    public static final String FIRSTNAME = "Wacek";
    public static final String LASTNAME = "Bolec";
    public static final Long ID = 1L;


    CustomerServiceImpl customerService;


    @Mock
    CustomerRepository customerRepository;


    @Before
    void setUp() {

        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE,customerRepository);
    }

    @Test
    void getAllCustomers() {

        //given

        List<Customer> customers = Arrays.asList(new Customer(),new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);
        //when

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then

        assertEquals(3,customerDTOS.size());
    }

    @Test
    void getCustomerById() {

        //given

        Customer customer = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);
        customer.setId(ID);

        //when(customerRepository.findById(anyLong())).thenReturn(customer);

        //when

        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        //then

        assertEquals(LASTNAME,customerDTO.getLastname());
        assertEquals(FIRSTNAME,customerDTO.getFirstname());


    }

    @Test
    public void createNewCustomer() throws Exception {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());
        savedCustomer.setId(1L);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when

        CustomerDTO savedDTO = customerService.createNewCustomer(customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(),savedDTO.getFirstname());
        assertEquals("/api/v1/customer/1",savedDTO.getCustomerUrl());




    }


    @Test
    public void savedCustomerByDTO() throws Exception {

        //given

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());
        savedCustomer.setId(customerDTO.getId());


        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);
        //when

        CustomerDTO savedDTO = customerService.saveCustomerByDTO(1L,customerDTO);

        //then

        assertEquals(customerDTO.getFirstname(),savedDTO.getFirstname());



    }






}