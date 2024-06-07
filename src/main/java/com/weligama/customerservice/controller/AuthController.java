package com.weligama.customerservice.controller;

import com.weligama.customerservice.entity.CustomerEntity;
import com.weligama.customerservice.model.LoginResponse;
import com.weligama.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            logger.debug("Login attempt for email: {}", loginRequest.getEmail());
            boolean isAuthenticated = customerService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
            if (isAuthenticated) {
                logger.debug("Login successful for email: {}", loginRequest.getEmail());
                String token = "some_generated_token"; // Replace with actual token generation logic
                return new ResponseEntity<>(new LoginResponse(true, "Login successful", token), HttpStatus.OK);
            } else {
                logger.debug("Login failed for email: {}", loginRequest.getEmail());
                return new ResponseEntity<>(new LoginResponse(false, "Login failed", null), HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            logger.error("Error during login", e);
            return new ResponseEntity<>(new LoginResponse(false, "Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/details/{email}")
    public ResponseEntity<CustomerEntity> getCustomerDetails(@PathVariable String email) {
        Optional<CustomerEntity> customer = customerService.findByEmail(email);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Data
    @AllArgsConstructor
    public static class LoginRequest {
        private String email;
        private String password;
    }
}