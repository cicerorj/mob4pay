package com.example.mob4pay.services.interfaces;

import com.example.mob4pay.models.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {
    
    List<CustomerDTO> getAll();
}
