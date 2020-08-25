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
public class JsonRequest  {
    private String cod;
    private float message;
    private int cnt;
    private City city;
    private List<WeatherList> list = new ArrayList<>();
    
    
	public JsonRequest() {
		super();
	}
	public JsonRequest(String cod, float message, int cnt, City city, List<WeatherList> list) {
		super();
		this.cod = cod;
		this.message = message;
		this.cnt = cnt;
		this.city = city;
		this.list = list;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public float getMessage() {
		return message;
	}
	public void setMessage(float message) {
		this.message = message;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<WeatherList> getList() {
		return list;
	}
	public void setList(List<WeatherList> list) {
		this.list = list;
	}
    
    
}
