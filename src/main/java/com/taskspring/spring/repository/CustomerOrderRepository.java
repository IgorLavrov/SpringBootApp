package com.taskspring.spring.repository;

import com.taskspring.spring.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    // Define custom query methods if needed
}