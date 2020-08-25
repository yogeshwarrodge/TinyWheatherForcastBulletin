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
    
    
	public Main() {
		super();
	}
	public Main(float temp, float feelsLike, float tempMin, float tempMax, float pressure, float seaLevel,
			float groundLevel, float humidity, float tempKf) {
		super();
		this.temp = temp;
		this.feelsLike = feelsLike;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.pressure = pressure;
		this.seaLevel = seaLevel;
		this.groundLevel = groundLevel;
		this.humidity = humidity;
		this.tempKf = tempKf;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(float feelsLike) {
		this.feelsLike = feelsLike;
	}
	public float getTempMin() {
		return tempMin;
	}
	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}
	public float getTempMax() {
		return tempMax;
	}
	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getSeaLevel() {
		return seaLevel;
	}
	public void setSeaLevel(float seaLevel) {
		this.seaLevel = seaLevel;
	}
	public float getGroundLevel() {
		return groundLevel;
	}
	public void setGroundLevel(float groundLevel) {
		this.groundLevel = groundLevel;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getTempKf() {
		return tempKf;
	}
	public void setTempKf(float tempKf) {
		this.tempKf = tempKf;
	}
    
    
}
