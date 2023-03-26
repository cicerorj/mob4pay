package com.example.mob4pay.openFeign.service;

import com.example.mob4pay.models.entities.Customer;
import com.example.mob4pay.openFeign.GetUsersFromDummy;
import com.example.mob4pay.openFeign.GetUsersFromJsonPlaceHold;
import com.example.mob4pay.openFeign.GetUsersFromRandomUser;
import com.example.mob4pay.services.impl.ReadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GetUsersService {

    GetUsersFromDummy getUsersFromDummy;
    GetUsersFromJsonPlaceHold getUsersFromJsonPlaceHold;
    GetUsersFromRandomUser getUsersFromRandomUser;
    GetUsersConverter getUsersConverter;
    ReadFile readFile;
    @Autowired
    public GetUsersService(GetUsersFromDummy getUsersFromDummy, GetUsersFromJsonPlaceHold getUsersFromJsonPlaceHold,
            GetUsersFromRandomUser getUsersFromRandomUser, GetUsersConverter getUsersConverter, ReadFile readFile) {
        this.getUsersFromDummy = getUsersFromDummy;
        this.getUsersFromJsonPlaceHold = getUsersFromJsonPlaceHold;
        this.getUsersFromRandomUser = getUsersFromRandomUser;
        this.getUsersConverter = getUsersConverter;
        this.readFile = readFile;
    }

    public List<Customer> allUsersFromFile() {
        List<Customer> allUsers = new ArrayList<>();
            allUsers.addAll( getUsersConverter.convertFromDummy( readFile.readDummyFile( ) ) );
            allUsers.addAll( getUsersConverter.convertFromPlaceHolder( readFile.readPlaceHold( ) ) );
            allUsers.addAll( getUsersConverter.convertFromRandomUserFromFile( readFile.readRandomUser( ) ) );

        return allUsers;
    }
    public List<Customer> getUsersFromPlaceHolder() {
        log.info( "Starting to GET users from Place Hold API" );
        String fromApi = getUsersFromJsonPlaceHold.getUsers().replaceAll("\\n","");
        return getUsersConverter.convertFromPlaceHolder(fromApi);

    }
    public List<Customer> getUsersFromDummy() {
        log.info( "Starting to GET users from Dummy API" );
        String fromApi = getUsersFromDummy.getUsers();
        return getUsersConverter.convertFromDummy(fromApi);

    }

    public List<Customer> getUsersFromRandomUser()  {
        int totalFromRandomUser = 10;
        try{
            log.info( "Starting to GET users from Random User API" );
            String listAsStringFromApi = "[";
            for (int i = 0; i < totalFromRandomUser; i++) {
                String fromApi = getUsersFromRandomUser.getUsers();
                listAsStringFromApi = listAsStringFromApi.concat( fromApi );
                listAsStringFromApi = listAsStringFromApi.concat( i != totalFromRandomUser - 1 ? "," : "" ) ;
            }
            listAsStringFromApi = listAsStringFromApi.concat( "]" );
            return getUsersConverter.convertFromRandomUser(listAsStringFromApi);
        } catch (Exception ex){
            try {
                throw new Exception( ex.getMessage() );
            } catch (Exception e) {
                throw new RuntimeException( e );
            }
        }

    }

}
