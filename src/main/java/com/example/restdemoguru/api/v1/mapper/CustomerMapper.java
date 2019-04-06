package com.example.restdemoguru.api.v1.mapper;

import com.example.restdemoguru.api.v1.model.CustomerDTO;
import com.example.restdemoguru.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);


}
