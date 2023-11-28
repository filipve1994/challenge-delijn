package com.delijn.developerchallenge.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Garage {

    private List<BusType> groot;

    private List<BusType> medium;

    private List<BusType> klein;
}
