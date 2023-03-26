package com.example.mob4pay.openFeign.models.dummy;

import com.example.mob4pay.models.entities.Customer;
import com.example.mob4pay.openFeign.Utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User{
    public int id;
    public String firstName;
    public String lastName;
    public String maidenName;
    public int age;
    public String gender;
    public String email;
    public String phone;
    public String username;
    public String password;
    public String birthDate;
    public String image;
    public String bloodGroup;
    public int height;
    public double weight;
    public String eyeColor;
    public Hair hair;
    public String domain;
    public String ip;
    public Address address;
    public String macAddress;
    public String university;
    public Bank bank;
    public Company company;
    public String ein;
    public String ssn;
    public String userAgent;

    public List<Customer> toEntity(RootDummy userList) {
        List<Customer> customerList = new ArrayList<>();
        userList.users.stream()
                .flatMap(f -> {
                    Customer entity = new Customer( );
                    entity.setFullName( f.firstName + " " + f.lastName );
                    entity.setAge( String.valueOf( f.age ) );
                    entity.setAddress( f.address.address );
                    entity.setCity( f.address.city );
                    entity.setState( f.address.state );
                    entity.setCpf( Generator.generateCpf( ) );
                    customerList.add( entity );
                    return null;
                }).collect(Collectors.toList());
        return customerList;
    }


}
