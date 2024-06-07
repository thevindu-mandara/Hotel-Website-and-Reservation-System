package com.weligama.adminservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weligama.adminservice.entity.AdminEntity;
import com.weligama.adminservice.repository.AdminRepository;
import com.weligama.adminservice.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ObjectMapper mapper;

    public boolean login(String email, String password) {
        logger.debug("Authenticating customer with email: {}", email);
        try {
            Optional<AdminEntity> optionalAdmin = adminRepository.findByEmail(email);
            if (optionalAdmin.isPresent()) {
                AdminEntity adminEntity = optionalAdmin.get();
                logger.debug("Found customer with email: {}", email);
                // Assuming no encryption for simplicity
                boolean isAuthenticated = adminEntity.getPassword().equals(password);
                logger.debug("Authentication result for email {}: {}", email, isAuthenticated);
                return isAuthenticated;
            } else {
                logger.debug("No customer found with email: {}", email);
                return false;
            }
        } catch (Exception e) {
            logger.error("Error during authentication for email: {}", email, e);
            return false; // Ensure false is returned if an exception occurs
        }
    }

}
