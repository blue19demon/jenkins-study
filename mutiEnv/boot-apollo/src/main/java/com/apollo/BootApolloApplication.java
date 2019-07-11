package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@EnableApolloConfig
public class BootApolloApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootApolloApplication.class, args);
	}
}

