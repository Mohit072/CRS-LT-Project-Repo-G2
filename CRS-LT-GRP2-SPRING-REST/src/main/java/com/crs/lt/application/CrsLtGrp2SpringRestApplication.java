package com.crs.lt.application;

import com.crs.lt.CRSApplication.ConfigurationJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan({"com.crs.lt.*"})
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
@Import({ConfigurationJDBC.class})
public class CrsLtGrp2SpringRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrsLtGrp2SpringRestApplication.class, args);
	}

}
