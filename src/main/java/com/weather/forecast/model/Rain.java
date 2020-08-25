package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rain {
//    @SerializedName("3h")
    @JsonProperty("3h")
    private int h3;

	public Rain(int h3) {
	super();
	this.h3 = h3;
}

	public int getH3() {
		return h3;
	}

	public void setH3(int h3) {
		this.h3 = h3;
	}
    
    

}
