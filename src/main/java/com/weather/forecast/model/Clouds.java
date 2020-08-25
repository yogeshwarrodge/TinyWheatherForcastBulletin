package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clouds {
    private float all;
    

	public Clouds() {
		super();
	}

	public Clouds(float all) {
		super();
		this.all = all;
	}

	public float getAll() {
		return all;
	}

	public void setAll(float all) {
		this.all = all;
	}
    
}
