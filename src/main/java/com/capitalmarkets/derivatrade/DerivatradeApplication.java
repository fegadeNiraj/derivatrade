package com.capitalmarkets.derivatrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DerivatradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DerivatradeApplication.class, args);
	}

}
