package com.weligama.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
