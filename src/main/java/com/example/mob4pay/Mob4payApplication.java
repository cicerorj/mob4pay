package com.example.mob4pay;

import com.example.mob4pay.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
@EnableMongoAuditing
public class Mob4payApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mob4payApplication.class, args);
    }
}
