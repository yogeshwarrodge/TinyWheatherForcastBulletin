package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FinalEntity {



	private int status;
    private String message;
    private int responseTime;
    private String description;
    private List<WeatherEntity> data = new ArrayList<>();
    
    
    
	public FinalEntity() {
		super();
	}
	public FinalEntity(int status, String message, int responseTime, String description, List<WeatherEntity> data) {
		super();
		this.status = status;
		this.message = message;
		this.responseTime = responseTime;
		this.description = description;
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<WeatherEntity> getData() {
		return data;
	}
	public void setData(List<WeatherEntity> data) {
		this.data = data;
	}
    
    
}
