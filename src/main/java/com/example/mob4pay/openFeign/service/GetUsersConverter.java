package com.example.mob4pay.openFeign.service;

import com.example.mob4pay.configs.Beans;
import com.example.mob4pay.models.entities.Customer;
import com.example.mob4pay.openFeign.models.dummy.RootDummy;
import com.example.mob4pay.openFeign.models.dummy.User;
import com.example.mob4pay.openFeign.models.placeHolder.RootPlaceHolder;
import com.example.mob4pay.openFeign.models.randomUser.RandomUserToSave;
import com.example.mob4pay.openFeign.models.randomUser.Result;
import com.example.mob4pay.openFeign.models.randomUser.RootDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetUsersConverter {

     Beans beans;
     @Autowired
     public GetUsersConverter(Beans beans) {
        this.beans = beans;
    }

    public List<Customer> convertFromRandomUser(String fromApi) {

        log.info( "Consume API with success. Starting converter to save at DB." );
        List<RootDTO> customersList = new ArrayList<>(  );

        try {
            customersList = beans.objectMapper().readValue(fromApi , new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException( e );
        }

        return new ArrayList<>(new RandomUserToSave().toCustomerEntityListFromRoot(customersList));
    }

    public List<Customer> convertFromRandomUserFromFile(String file) {

        log.info( "Consume API with success. Starting converter to save at DB." );
        List<RootDTO> customersList = new ArrayList<>();

            try {
                customersList.addAll(beans.objectMapper().readValue(file , new TypeReference<List<RootDTO>>(){}));
            } catch (JsonProcessingException e) {
                throw new RuntimeException( e );
            }

            return new ArrayList<>(new RandomUserToSave().toCustomerEntityList(customersList.stream()
                    .flatMap(f -> f.results.stream()).toList()));
    }

    public List<Customer> convertFromDummy(String fromApi)  {

        log.info( "Consume API with success. Starting converter to save at DB." );
        RootDummy rootDummy;

        try {
            rootDummy = beans.objectMapper().readValue(fromApi , new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException( e );
        }

        return new User().toEntity(rootDummy);
    }

    public List<Customer> convertFromPlaceHolder(String fromApi)  {

        log.info( "Consume API with success. Starting converter to save at DB." );
        List<RootPlaceHolder> rootPlaceHolder;

        try {
            rootPlaceHolder = beans.objectMapper().readValue(fromApi , new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException( e );
        }

        return new RootPlaceHolder().toEntityList( rootPlaceHolder );
    }

}
