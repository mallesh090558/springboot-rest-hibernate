package com.codingdream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsersApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(UsersApplication.class, args);
	}
}
