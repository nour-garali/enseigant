package com.nour.enseignant;


import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nour.enseignant.EnseignantApplication;
import com.nour.enseignant.entities.Enseignant;
import com.nour.enseignant.services.EnseignantService;

@SpringBootApplication
public class EnseignantApplication {

	@Autowired 
	EnseignantService EnseignantService;

	public static void main(String[] args) {
		SpringApplication.run(EnseignantApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		
		EnseignantService.saveEnseignant(new Enseignant( "nour", "tunis",new Date())); 
		EnseignantService.saveEnseignant(new Enseignant("iset nabeul","nabeul",new Date())); 
		EnseignantService.saveEnseignant(new Enseignant("iset kelibia", "nabeul", new Date()));
		 
	}
}



