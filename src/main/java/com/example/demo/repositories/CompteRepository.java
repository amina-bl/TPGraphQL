package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Compte;
import com.example.demo.entities.TypeCompte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	@Query("SELECT SUM(c.solde) FROM Compte c")
    double sumSolde();	
	
	List<Compte> findByType(TypeCompte type);
}