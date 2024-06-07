package com.weligama.adminservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Admin {
    private Long id;
    private String email;
    private String password;
}
