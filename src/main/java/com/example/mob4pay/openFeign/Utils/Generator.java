package com.example.mob4pay.openFeign.Utils;

import com.github.javafaker.Faker;

public class Generator {

    public static String generateCpf(){
        return new Faker().regexify("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}");
    }

    public static String ageGenerator(){
        return new Faker(  ).regexify( "([0-9]{2})" );
    }

    public static String stateGenerator(){
       return new Faker( ).address().state();
    }
}
