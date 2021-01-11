package com.empresa.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServicesApplication {
	//Então nossa aplicação funciona assim nosso Resource chama o metodo Service que 
	//por sua vez chama o metodo repositories
	public static void main(String[] args) {
		SpringApplication.run(WebServicesApplication.class, args);
	}

}
