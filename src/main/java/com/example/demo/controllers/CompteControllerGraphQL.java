package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.entities.Compte;
import com.example.demo.entities.TypeCompte;
import com.example.demo.repositories.CompteRepository;

import jakarta.transaction.Transaction;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CompteControllerGraphQL { 
	private CompteRepository compteRepository;

	@QueryMapping
	public List<Compte> allComptes(){ 
		return compteRepository.findAll();
	}
	@QueryMapping
	public Compte compteById(@Argument Long id) {
		Compte compte= compteRepository.findById(id). orElse (null);
		if (compte == null) throw new RuntimeException(String.format("Compte %s not found", id));
		else return compte;
	}



	@MutationMapping
	public Compte saveCompte (@Argument Compte compte){ 
		return compteRepository.save(compte);
	}
	@QueryMapping
	public Map<String, Object> totalSolde() {
		long count=compteRepository.count();
		double sum = compteRepository.sumSolde();
		double average= count > 0? sum/ count :0;
		return Map. of (
		"count", count, "sum", sum,
		"average", average );
	}
	@QueryMapping
	public List<Compte> compteByType(@Argument TypeCompte type){
		return compteRepository.findByType(type);
		
	}
	
	@MutationMapping
	public Boolean deleteCompte(@Argument Long id) {
		  if (compteRepository.existsById(id)) { 
		        compteRepository.deleteById(id); 
		        return true; 
		    } else {
		        return false; 
		    }	
	}
	
	
}
