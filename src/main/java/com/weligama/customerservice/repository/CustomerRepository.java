package com.weligama.customerservice.repository;

import com.weligama.customerservice.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);
}