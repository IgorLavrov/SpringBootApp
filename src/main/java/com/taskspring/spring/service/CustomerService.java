package com.taskspring.spring.service;

import com.taskspring.spring.models.Customer;
import com.taskspring.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        // Add validation or business logic if needed
        return customerRepository.save(customer);
    }

    // Add more methods as per your business requirements
}