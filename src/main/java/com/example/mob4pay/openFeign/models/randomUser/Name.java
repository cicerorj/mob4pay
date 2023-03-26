package com.example.mob4pay.openFeign.models.randomUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Name {

    public String title;
    public String first;
    public String last;
}
