package com.example.mob4pay.openFeign.models.placeHolder;

import com.example.mob4pay.models.entities.Customer;
import com.example.mob4pay.openFeign.Utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class RootPlaceHolder {
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

    public List<Customer> toEntityList(List<RootPlaceHolder> list){
        List<Customer> customer = new ArrayList<>();

        list.stream()
                .flatMap( f -> {
                    Customer entity = new Customer();
                    entity.setFullName( f.name );
                    entity.setAge( Generator.ageGenerator( ) );
                    entity.setAddress( f.address.street );
                    entity.setCity( f.address.city );
                    entity.setState( Generator.stateGenerator() );
                    entity.setCpf( Generator.generateCpf() );
                    customer.add( entity );
                    return null;
                } ).toList();
        return customer;
    }
}