package com.lt.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class CrsDevAppRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsDevAppRestApplication.class, args);
	}

}
