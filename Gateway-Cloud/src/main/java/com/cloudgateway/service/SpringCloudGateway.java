package com.cloudgateway.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudGateway {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGateway.class, args);
	}
	
	
}
