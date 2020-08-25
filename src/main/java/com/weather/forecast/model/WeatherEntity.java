package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity {

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private List<Result> results = new ArrayList<>();
}
