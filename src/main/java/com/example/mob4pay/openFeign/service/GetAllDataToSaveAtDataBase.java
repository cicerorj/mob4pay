package com.example.mob4pay.openFeign.service;

import com.example.mob4pay.models.entities.Customer;
import com.example.mob4pay.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class GetAllDataToSaveAtDataBase {

    CustomerRepository customerRepository;
    GetUsersService getUsersService;
    @Autowired
    public GetAllDataToSaveAtDataBase(CustomerRepository customerRepository, GetUsersService getUsersService) {
        this.customerRepository = customerRepository;
        this.getUsersService = getUsersService;
    }

    public void startGetAndSetDataOnDB() {
        List<Customer> allCustomers = new ArrayList<>();

        try{
            allCustomers.addAll( getUsersService.getUsersFromPlaceHolder() );
            allCustomers.addAll( getUsersService.getUsersFromRandomUser() );
            allCustomers.addAll( getUsersService.getUsersFromDummy() );

            log.info( "Checking if API has worked." );

        }catch (Exception ex){
            throw new RuntimeException();
        } finally {
            if(isApiGetErrorOccurred(allCustomers)){
                log.info( "API not worked. Starting get data from files." );
                try {
                    allCustomers.addAll( getUsersService.allUsersFromFile());
                } catch (Exception e) {
                    throw new RuntimeException( e );
                }
            }
            log.info( "All data converted. Starting to save at DB." );
            customerRepository.saveAll( allCustomers );
        }

    }

    private boolean isApiGetErrorOccurred(List<Customer> apiResponse){
        return apiResponse.isEmpty();
    }
}
