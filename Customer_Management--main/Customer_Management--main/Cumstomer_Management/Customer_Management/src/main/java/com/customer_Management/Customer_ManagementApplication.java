package com.customer_Management;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Customer_ManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(Customer_ManagementApplication.class, args);
	}

	@Bean
   public ModelMapper modelMapper(){
     return new ModelMapper();
   }
}
