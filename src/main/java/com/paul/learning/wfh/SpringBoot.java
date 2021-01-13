package com.paul.learning.wfh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBoot extends SpringBootServletInitializer {


	/**
	 * Main method that starts the application.
	 * @param args The args.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}

}
