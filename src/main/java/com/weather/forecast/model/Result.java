package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private String workingHours;
    private float avgMaxTemp;
    private float avgMinTemp;
    private float humidity;
}
