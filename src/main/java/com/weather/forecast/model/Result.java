package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Result {

    private String workingHours;
    private float avgMaxTemp;
    private float avgMinTemp;
    private float humidity;
    
    
	public Result(String workingHours, float avgMaxTemp, float avgMinTemp, float humidity) {
		super();
		this.workingHours = workingHours;
		this.avgMaxTemp = avgMaxTemp;
		this.avgMinTemp = avgMinTemp;
		this.humidity = humidity;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	public float getAvgMaxTemp() {
		return avgMaxTemp;
	}
	public void setAvgMaxTemp(float avgMaxTemp) {
		this.avgMaxTemp = avgMaxTemp;
	}
	public float getAvgMinTemp() {
		return avgMinTemp;
	}
	public void setAvgMinTemp(float avgMinTemp) {
		this.avgMinTemp = avgMinTemp;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
    
    
}
