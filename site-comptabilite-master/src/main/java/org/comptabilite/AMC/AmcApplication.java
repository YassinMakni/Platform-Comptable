package org.comptabilite.AMC;

import org.comptabilite.AMC.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AmcApplication {


	public static void main(String[] args) {
		SpringApplication.run(AmcApplication.class, args);
	}


}

