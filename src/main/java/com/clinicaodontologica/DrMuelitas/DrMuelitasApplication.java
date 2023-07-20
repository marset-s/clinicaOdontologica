package com.clinicaodontologica.DrMuelitas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DrMuelitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrMuelitasApplication.class, args);
		LOGGER.info("🤩 Dr.Muelitas is running... ");
	}

}
