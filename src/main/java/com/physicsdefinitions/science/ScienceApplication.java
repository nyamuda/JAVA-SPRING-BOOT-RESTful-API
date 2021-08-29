package com.physicsdefinitions.science;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ScienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScienceApplication.class, args);

		System.out.println("thank you so much");
	}

}
