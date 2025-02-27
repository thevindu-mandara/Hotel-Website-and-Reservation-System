package com.weligama.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private boolean success;
    private String message;
    private String token;

    public LoginResponse() {
    }
}