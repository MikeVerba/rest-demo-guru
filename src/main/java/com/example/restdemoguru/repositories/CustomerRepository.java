package com.example.restdemoguru.repositories;

import com.example.restdemoguru.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
