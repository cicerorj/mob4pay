package com.example.mob4pay.services.impl;

import com.example.mob4pay.models.dtos.CustomerDTO;
import com.example.mob4pay.models.entities.Customer;
import com.example.mob4pay.repository.CustomerRepository;
import com.example.mob4pay.services.interfaces.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAll() {
        log.info("Starting select to get all Customers.");
        List<Customer> customersFromDb = customerRepository.findAll();
        return new CustomerDTO().toDTOList(customersFromDb);
    }
}
