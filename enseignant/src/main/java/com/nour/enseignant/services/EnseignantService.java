package com.nour.enseignant.services;
import java.util.List;

import org.springframework.data.domain.Page;

import com.nour.enseignant.entities.Enseignant;

public interface EnseignantService {
    Enseignant saveEnseignant(Enseignant e);
    Enseignant updateEnseignant(Enseignant e);
    void deleteEnseignant(Enseignant e);
    void deleteEnseignantById(Long idEnseignant);
    Enseignant getEnseignant(Long idEnseignant);
    List<Enseignant> getAllEnseignant();
    Page<Enseignant> getAllEnseignantParPage(int page, int size);
}