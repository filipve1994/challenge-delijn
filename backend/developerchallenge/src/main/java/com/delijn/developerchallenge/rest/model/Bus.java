package com.delijn.developerchallenge.rest.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @JsonAlias(value = "busNummer")
    private String bus;

    private BusType type;
}
