package com.delijn.developerchallenge.rest.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StelPlaats {

    @JsonAlias(value = "stelplaats")
    private String name;

//    private int sizeLargeBus = 4;
//    private int mediumBus = 6;
//    private int littleBus = 10;

    private List<Bus> parking;

    private Garage garage;

}
