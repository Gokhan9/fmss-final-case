package com.patikadev.fmss.finalcase.advertisement_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdvertisementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisementServiceApplication.class, args);
	}

}
