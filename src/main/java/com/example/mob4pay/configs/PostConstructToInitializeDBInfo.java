package com.example.mob4pay.configs;

import com.example.mob4pay.openFeign.service.GetAllDataToSaveAtDataBase;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class PostConstructToInitializeDBInfo {

    GetAllDataToSaveAtDataBase getAllDataToSaveAtDataBase;

    @Autowired
    public PostConstructToInitializeDBInfo(GetAllDataToSaveAtDataBase getAllDataToSaveAtDataBase) {
        this.getAllDataToSaveAtDataBase = getAllDataToSaveAtDataBase;
    }

    @PostConstruct
    private void postConstruct() {
        try{
            log.info( "Starting process to GET and insert data on Data base." );
            getAllDataToSaveAtDataBase.startGetAndSetDataOnDB();
            log.info( "Finish process using API to GET and insert data on Data base." );
        }catch (Throwable  ex){
            log.info( "Finish process using FILES to GET and insert data on Data base." );
        }
    }
}
