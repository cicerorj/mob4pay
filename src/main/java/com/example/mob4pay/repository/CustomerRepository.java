package com.example.mob4pay.repository;

import com.example.mob4pay.models.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CustomerRepository extends MongoRepository<Customer, String > {
}
