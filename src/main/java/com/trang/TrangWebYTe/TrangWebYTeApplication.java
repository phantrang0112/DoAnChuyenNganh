package com.trang.TrangWebYTe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class TrangWebYTeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrangWebYTeApplication.class, args);
	}

}
