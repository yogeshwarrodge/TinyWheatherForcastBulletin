package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherList {
    private long dt;
    private Main main;
    private java.util.List<Weather> weather = new ArrayList<>();
    private Clouds clouds;
    private Wind wind;
    private Snow rain;
    private Snow snow;
    private int visibility;
    private float pop;
    private Sys sys;
    @JsonProperty("dt_txt")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtTxt;

}
