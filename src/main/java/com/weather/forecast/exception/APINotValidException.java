package com.weather.forecast.exception;

public class APINotValidException extends RuntimeException {

	
	private APINotValidException() {
    }

    public APINotValidException(String message) {
        super(message);
    }

    
}
