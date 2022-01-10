package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.lt.config.SpringJDBCConfiguration;

//import com.lt.config.SpringJDBCConfiguration;

@ComponentScan({"com.lt.*"})
@EnableWebMvc
@SpringBootApplication
@EnableAutoConfiguration
@Import({SpringJDBCConfiguration.class})

public class CrsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsProjectApplication.class, args);
		//ApplicationContext context=SpringApplication.run(SpringJDBCConfiguration.class);
	}

}
