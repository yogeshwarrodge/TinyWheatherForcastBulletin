package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {

    private float speed;
    private float deg;
    
    
	public Wind(float speed, float deg) {
		super();
		this.speed = speed;
		this.deg = deg;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getDeg() {
		return deg;
	}
	public void setDeg(float deg) {
		this.deg = deg;
	}
    
    
}
