package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    private float temp;
    @JsonProperty("feels_like")
    private float feelsLike;
    @JsonProperty("temp_min")
    private float tempMin;
    @JsonProperty("temp_max")
    private float tempMax;
    private float pressure;
    @JsonProperty("sea_level")
    private float seaLevel;
    @JsonProperty("grnd_level")
    private float groundLevel;
    private float humidity;
    @JsonProperty("temp_kf")
    private float tempKf;
}
