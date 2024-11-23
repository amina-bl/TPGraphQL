package com.example.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor 
@Setter
@Getter
public class Compte {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private double solde;

	@Temporal(TemporalType.DATE) 
	private String  dateCreation;
	@Enumerated (EnumType.STRING) 
	private TypeCompte type;
	
	  public Compte(double solde, Date  dateCreation, TypeCompte type) {
	        this.solde = solde;
	        this.dateCreation = dateCreation.toString();
	        this.type = type;
	    }
}