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
    
	public City() {
		super();
	}
	public City(int id, String name, Coordinates coordinates, String country, long timezone, long sunrise, long sunset,
			int population) {
		super();
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
		this.country = country;
		this.timezone = timezone;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.population = population;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getTimezone() {
		return timezone;
	}
	public void setTimezone(long timezone) {
		this.timezone = timezone;
	}
	public long getSunrise() {
		return sunrise;
	}
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}
	public long getSunset() {
		return sunset;
	}
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
    
}
