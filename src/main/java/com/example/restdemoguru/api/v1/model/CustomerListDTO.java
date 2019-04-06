package com.example.restdemoguru.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerListDTO {
    List<CustomerDTO> customerDTO;


    public CustomerListDTO(List<CustomerDTO> customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<CustomerDTO> getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(List<CustomerDTO> customerDTO) {
        this.customerDTO = customerDTO;
    }
}
