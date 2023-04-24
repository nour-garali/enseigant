package com.nour.enseignant.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nour.enseignant.entities.Enseignant;
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

}

