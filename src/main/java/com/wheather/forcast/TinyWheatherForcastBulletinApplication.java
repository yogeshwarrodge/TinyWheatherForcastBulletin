package com.wheather.forcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TinyWheatherForcastBulletinApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyWheatherForcastBulletinApplication.class, args);
	}

	@RequestMapping("/")
	public String welcome() {
		return "welcome to tiny wheather app...!!!";
	}
}
