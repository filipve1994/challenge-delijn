package com.delijn.developerchallenge.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.jdbc.Size;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Garage {

    private List<SizeBus> groot;

    private List<SizeBus> medium;

    private List<SizeBus> klein;
}
