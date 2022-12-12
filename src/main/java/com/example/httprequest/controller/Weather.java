package com.example.httprequest.controller;

import com.example.httprequest.util.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value = "/weather")
public class Weather {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<?> getCountry() {
        try {
            HttpRequest request = HttpRequest
                    .get("http://api.weatherstack.com/current?access_key=711de9048e80b96a80710229c738c2c9&query=Copenhagen")
                    .connectTimeout(12000);
            String res = request.body();
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
