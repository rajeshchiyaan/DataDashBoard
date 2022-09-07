package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:csv.properties")
public class DataDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataDashBoardApplication.class, args);
		System.out.println("Hello World");
		System.out.println("Spring boot");
	}

}
