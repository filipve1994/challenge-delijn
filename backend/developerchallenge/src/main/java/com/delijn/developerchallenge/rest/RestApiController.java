package com.delijn.developerchallenge.rest;

import com.delijn.developerchallenge.rest.model.StelPlaats;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RestApiController {

    public static final String DATA = """
{
  "stelplaats": "De Lijn Arsenaal",
  "parking": [
    {"bus": "1000","type": "GROOT"},
    {"bus": "1001","type": "GROOT"},
    {"bus": "1002","type": "GROOT"},
    {"bus": "2000","type": "NORMAAL"},
    {"bus": "2001","type": "NORMAAL"},
    {"bus": "2002","type": "NORMAAL"},
    {"bus": "2003","type": "NORMAAL"},
    {"bus": "2004","type": "NORMAAL"},
    {"bus": "2005","type": "NORMAAL"},
    {"bus": "3000","type": "MINI"},
    {"bus": "3001","type": "MINI"},
    {"bus": "3002","type": "MINI"},
    {"bus": "3003","type": "MINI"},
    {"bus": "3004","type": "MINI"},
    {"bus": "3005","type": "MINI"},
    {"bus": "3006","type": "MINI"},
    {"bus": "3007","type": "MINI"},
    {"bus": "3008","type": "MINI"},
    {"bus": "3009","type": "MINI"},
    {"bus": "3010","type": "MINI"},
    {"bus": "3011","type": "MINI"},
    {"bus": "3012","type": "MINI"}
  ],
  "garage": {
    "groot": [],
    "medium": [],
    "klein": []
  }
}""";

    public RestApiController() throws JsonProcessingException {
        System.out.println("restapicontroller logging");
        var objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {
            var grant = objectMapper.readValue(DATA, StelPlaats.class);
            System.out.println(grant);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        StelPlaats stelPlaats = objectMapper.readValue(DATA, StelPlaats.class);
    }


    @GetMapping(value = "/data")
    public ResponseEntity getData() {
        return ResponseEntity.ok(DATA);
    }

    @GetMapping(value = "/fromfile")
    public ResponseEntity getFromFile() {
        File file = new File(
                this.getClass().getClassLoader().getResource("inputfile.json").getFile()
        );

        var objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        StelPlaats stelPlaats;
        try {
            stelPlaats = objectMapper.readValue(file, StelPlaats.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(stelPlaats);
    }

}
