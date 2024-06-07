package com.weligama.adminservice.repository;

import com.weligama.adminservice.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByEmail(String email);
}
