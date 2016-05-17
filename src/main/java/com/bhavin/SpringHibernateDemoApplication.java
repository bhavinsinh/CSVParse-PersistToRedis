package com.bhavin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = {"com.bhavin"})
@Configuration
public class SpringHibernateDemoApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(SpringHibernateDemoApplication.class, args);
	}
}
