package com.example.restdemoguru.bootstrap;

import com.example.restdemoguru.domain.Category;
import com.example.restdemoguru.domain.Customer;
import com.example.restdemoguru.repositories.CategoryRepository;
import com.example.restdemoguru.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        loadCategoryData();

        loadCustomerData();

    }

    private void loadCustomerData() {
        Customer jackSparrow = new Customer();
        jackSparrow.setFirstname("Jack");
        jackSparrow.setLastname("Sparrow");

        customerRepository.save(jackSparrow);

        Customer jamesBond = new Customer();
        jamesBond.setFirstname("James");
        jamesBond.setLastname("Bond");

        customerRepository.save(jamesBond);

        System.out.println("Customer data loaded"+customerRepository.count());
    }

    private void loadCategoryData() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Category data loaded" + categoryRepository.count());
    }
}
