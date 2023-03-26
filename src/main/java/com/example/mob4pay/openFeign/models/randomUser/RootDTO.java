package com.example.mob4pay.openFeign.models.randomUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RootDTO {

    @JsonProperty("results")
    public List<Result> results = new ArrayList<>();
    public Info info;
}
