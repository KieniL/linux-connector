package com.kienast.connectorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class LinuxconnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinuxconnectorApplication.class, args);
	}

}
