package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NissanAmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NissanAmsBackendApplication.class, args);
		
		System.out.println("started");
	}

}
