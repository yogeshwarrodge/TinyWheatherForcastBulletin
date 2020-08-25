package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonRequest  {
    private String cod;
    private float message;
    private int cnt;
    private City city;
    private List<WeatherList> list = new ArrayList<>();
}
