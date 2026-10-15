package com.nbgraciano.analisecredito;

import com.nbgraciano.analisecredito.service.AnaliseCreditoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@AllArgsConstructor
@SpringBootApplication
public class AnalisecreditoApplication {

	private AnaliseCreditoService service;

	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			service.analisar();
		};
	}
}
