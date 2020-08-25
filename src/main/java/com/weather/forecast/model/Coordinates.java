package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {
    private float lat;
    private float lon;
    
    
	public Coordinates() {
		super();
	}
	public Coordinates(float lat, float lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
    
    
}
