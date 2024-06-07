package com.weligama.customerservice.service;

import com.weligama.customerservice.entity.CustomerEntity;
import com.weligama.customerservice.model.Customer;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

public interface CustomerService {
    CustomerEntity createCustomer(Customer customer);

    Iterable<CustomerEntity> getCustomer();

    boolean authenticate(String email, String password);

    Optional<CustomerEntity> findByEmail(String email);

}
