package com.weligama.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Customer {
    private Integer cusId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String address;
    private String email;
    private String nic;
    private String contactNumber;
    private String password;
}
