package com.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceBankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBankAccountApplication.class, args);
	}

}
