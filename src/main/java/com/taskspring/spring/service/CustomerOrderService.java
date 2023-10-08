package com.taskspring.spring.service;
import com.taskspring.spring.models.CustomerOrder;
import com.taskspring.spring.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    public Optional<CustomerOrder> getCustomerOrderById(Long id) {
        return customerOrderRepository.findById(id);
    }

    public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
        // You can add validation or business logic here if needed
        return customerOrderRepository.save(customerOrder);
    }
    public boolean deleteCustomerOrder(Long id) {
        try {
            customerOrderRepository.deleteById(id);
            return true; // Deletion was successful
        } catch (Exception e) {
            return false; // Deletion failed
        }
    }
    // You can implement more methods for updating and handling customer orders
}
