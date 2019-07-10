package com.muti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EnvTestApplication {
	@Value("${foo.name}")
	private String foo;

	public static void main(String[] args) {
		SpringApplication.run(EnvTestApplication.class, args);
	}

	@GetMapping("foo")
	public String foo() {
		return foo;
	}
}
