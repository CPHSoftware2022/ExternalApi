package com.example.httprequest.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weather {

    @JsonProperty("weather")
    private String weather;
    @JsonProperty("city")
    private String city;
    @JsonProperty("temp")
    private String temp;
}
