package com.weligama.adminservice.controller;

import com.weligama.adminservice.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest loginRequest) {
        return adminService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @Data
    @AllArgsConstructor
    static class LoginRequest {
        private String email;
        private String password;
    }
}
