package com.example.mob4pay.models.dtos;

import com.example.mob4pay.models.entities.Customer;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 2L;
    private String fullName;
    private String age;
    private String address;
    private String city;
    private String state;
    private String cpf;

    public CustomerDTO toDTO(Customer entity){
        CustomerDTO dto = new CustomerDTO();
        dto.fullName = entity.getFullName();
        dto.age = entity.getAge();
        dto.address = entity.getAddress();
        dto.city = entity.getCity();
        dto.state = entity.getState();
        dto.cpf = entity.getCpf();

        return dto;
    }

    public List<CustomerDTO> toDTOList(List<Customer> entities){
        List<CustomerDTO> dtos = new ArrayList<>();
        for (Customer entity : entities
        ) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}
