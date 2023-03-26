package com.example.mob4pay.openFeign.models.randomUser;

import com.example.mob4pay.models.dtos.CustomerDTO;
import com.example.mob4pay.models.entities.Customer;
import com.example.mob4pay.openFeign.Utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUserToSave {

    public CustomerDTO customerDTO;

    public List<CustomerDTO> toCustomerDTOList(List<Result> results) {
        List<CustomerDTO> customerList = new ArrayList<>();
        results.stream()
                .flatMap(f -> {
                    CustomerDTO dto = new CustomerDTO();
                    dto.setFullName(f.name.first + f.name.last);
                    dto.setAge(String.valueOf(f.dob.age));
                    dto.setAddress(f.location.street.name);
                    dto.setCity(f.location.city);
                    dto.setState(f.location.state);
                    dto.setCpf( Generator.generateCpf());
                    customerList.add(dto);
                    return null;
                });
        return customerList;
    }

    public List<Customer> toCustomerEntityList(List<Result> results) {
        List<Customer> customerList = new ArrayList<>();
        extracted( results, customerList );
        return customerList;
    }

    public List<Customer> toCustomerEntityListFromRoot(List<RootDTO> root) {
        List<Customer> customerList = new ArrayList<>();
        RootDTO rootDTO = new RootDTO();
        List<Result> results = new ArrayList<>();
        root.stream()
                        .flatMap( f -> {
                            results.addAll( f.results );
                            return null;
                        } ).toList();
        extracted( results, customerList );
        return customerList;
    }

    private static void extracted(List<Result> results, List<Customer> customerList) {
        results.stream()
                .flatMap(f -> {
                    Customer entity = new Customer();
                    entity.setFullName(f.name.first + " " + f.name.last);
                    entity.setAge(String.valueOf(f.dob.age));
                    entity.setAddress(f.location.street.name);
                    entity.setCity(f.location.city);
                    entity.setState(f.location.state);
                    entity.setCpf( Generator.generateCpf());
                    customerList.add(entity);
                    return null;
                }).collect(Collectors.toList());
    }
}
