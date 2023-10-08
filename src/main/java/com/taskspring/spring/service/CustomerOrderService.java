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

        return customerOrderRepository.save(customerOrder);
    }
    public boolean deleteCustomerOrder(Long id) {
        try {
            customerOrderRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
