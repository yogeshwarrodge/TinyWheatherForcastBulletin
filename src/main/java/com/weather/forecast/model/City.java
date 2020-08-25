package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int id;
    private String name;
    @JsonProperty("coord")
    private Coordinates coordinates;
    private String country;
    private long timezone;
    private long sunrise;
    private long sunset;
    private int population;
}
