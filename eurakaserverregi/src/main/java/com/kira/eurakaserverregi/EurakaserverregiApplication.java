package com.kira.eurakaserverregi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakaserverregiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurakaserverregiApplication.class, args);
	}

}
