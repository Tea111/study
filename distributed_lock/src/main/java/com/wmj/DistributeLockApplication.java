package com.wmj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;


@SpringBootApplication()
public class DistributeLockApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributeLockApplication.class, args);
	}

}
