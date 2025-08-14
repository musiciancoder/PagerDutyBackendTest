package com.example.backend;

import com.example.backend.client.PagerDutyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	//
	//static PagerDutyClient pagerDutyClient;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		//pagerDutyClient.prueba();
	}

}
