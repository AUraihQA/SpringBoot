package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class StarterProjectApplication {

	public static void main(String[] args) {
		// ctrl + shift + o - optimises imports
		ApplicationContext beanbag = SpringApplication.run(StarterProjectApplication.class, args);

		System.out.println(beanbag.getBean("getTime", String.class));		
	}
	

}



