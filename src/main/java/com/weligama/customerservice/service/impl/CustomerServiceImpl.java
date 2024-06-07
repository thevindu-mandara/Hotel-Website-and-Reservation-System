package com.weligama.customerservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weligama.customerservice.entity.CustomerEntity;
import com.weligama.customerservice.model.Customer;
import com.weligama.customerservice.repository.CustomerRepository;
import com.weligama.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public CustomerEntity createCustomer(Customer customer){
        //Model to entity conversion
        CustomerEntity entity = mapper.convertValue(customer, CustomerEntity.class);


        //Saving Data
        return customerRepository.save(entity);
    }

    @Override
    public Optional<CustomerEntity> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Iterable<CustomerEntity> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public boolean authenticate(String email, String password) {
        logger.debug("Authenticating customer with email: {}", email);
        try {
            Optional<CustomerEntity> optionalCustomer = customerRepository.findByEmail(email);
            if (optionalCustomer.isPresent()) {
                CustomerEntity customerEntity = optionalCustomer.get();
                logger.debug("Found customer with email: {}", email);
                // Assuming no encryption for simplicity
                boolean isAuthenticated = customerEntity.getPassword().equals(password);
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














    /*@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public CustomerEntity createCustomer(Customer customer) {
        // Model to entity conversion
        CustomerEntity entity = mapper.convertValue(customer, CustomerEntity.class);
        return customerRepository.save(entity);
    }
    @Override
    public List<Customer> getCustomer(){
        ArrayList<Customer> list = new ArrayList();
        list.add(new Customer(100, "Thevindu", "Mandara", "297/2, Passara " +
                "Road, Viharagoda, Badulla", "thevindumandara@gmail.com", "200308213000", "07787" +
                "37441", "Please meka hariyanna"));
        return list;
    }*/
