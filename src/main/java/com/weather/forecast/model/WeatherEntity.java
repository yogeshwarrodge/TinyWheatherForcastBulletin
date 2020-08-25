package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class WeatherEntity {

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private List<Result> results = new ArrayList<>();
    
    
	public WeatherEntity(LocalDate date, List<Result> results) {
		super();
		this.date = date;
		this.results = results;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
    
    
}
