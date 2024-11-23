package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Compte;
import com.example.demo.entities.TypeCompte;
import com.example.demo.repositories.CompteRepository;
@SpringBootApplication
public class TPgraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TPgraphQlApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args->{
		
			compteRepository.save(new Compte(Math.random() * 9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(Math.random() * 9000, new Date(), TypeCompte.COURANT));

			
			compteRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}
}
