package com.facchinil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class EntryAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntryAccessApplication.class, args);
	}

}
