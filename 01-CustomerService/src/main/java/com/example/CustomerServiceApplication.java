package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication {

	@Autowired
	CustomerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
		System.out.println("from boot main class");
	}

}
