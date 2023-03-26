package com.example.mob4pay.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
@Slf4j
public class ReadFile {

    String data = "";
    public String readDummyFile() {
        if (fileToString( "dummy.json" ))
            return data;
        return null;
    }

    public String readPlaceHold() {
        if (fileToString( "placeHolder.json" )){
            var a = data;
            return data;
        }
        return null;
    }

    public String readRandomUser() {
        if (fileToString( "randomUser.json" ))
            return data;
        return null;
    }

    private boolean fileToString(String pathname) {
        try {

            File myObj = new File( pathname );
            Scanner myReader = new Scanner( myObj );
            System.out.println( myObj );
            while (myReader.hasNextLine( )) {
                 data = myReader.nextLine( );
            }
            myReader.close( );
            return true;
        } catch (FileNotFoundException e) {
            log.debug( "An error occurred." );
            e.printStackTrace( );
        }
        return false;
    }
}
