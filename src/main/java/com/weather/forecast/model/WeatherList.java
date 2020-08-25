package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class WeatherList {
    private long dt;
    private Main main;
    private List<Weather> weather = new ArrayList<>();
    private Clouds clouds;
    private Wind wind;
    private Snow rain;
    private Snow snow;
    private int visibility;
    private float pop;
    private Sys sys;
    @JsonProperty("dt_txt")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtTxt;
    
    
	public WeatherList(long dt, Main main, List<Weather> weather, Clouds clouds, Wind wind, Snow rain, Snow snow,
			int visibility, float pop, Sys sys, LocalDateTime dtTxt) {
		super();
		this.dt = dt;
		this.main = main;
		this.weather = weather;
		this.clouds = clouds;
		this.wind = wind;
		this.rain = rain;
		this.snow = snow;
		this.visibility = visibility;
		this.pop = pop;
		this.sys = sys;
		this.dtTxt = dtTxt;
	}
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Snow getRain() {
		return rain;
	}
	public void setRain(Snow rain) {
		this.rain = rain;
	}
	public Snow getSnow() {
		return snow;
	}
	public void setSnow(Snow snow) {
		this.snow = snow;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public float getPop() {
		return pop;
	}
	public void setPop(float pop) {
		this.pop = pop;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public LocalDateTime getDtTxt() {
		return dtTxt;
	}
	public void setDtTxt(LocalDateTime dtTxt) {
		this.dtTxt = dtTxt;
	}
	

}
