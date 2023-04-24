package com.nour.enseignant.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nour.enseignant.entities.Enseignant;
import com.nour.enseignant.repos.EnseignantRepository;

@Service
public class EnseignantServiceImpl implements EnseignantService {
    @Autowired
    EnseignantRepository enseignantRepository;

    @Override
    public Enseignant saveEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public void deleteEnseignant(Enseignant e) {
        enseignantRepository.delete(e);
    }

    @Override
    public void deleteEnseignantById(Long id) {
        enseignantRepository.deleteById(id);
    }

    @Override
    public Enseignant getEnseignant(Long id) {
        return enseignantRepository.findById(id).get();
    }

    @Override
    public List<Enseignant> getAllEnseignant() {
        return enseignantRepository.findAll();
    }

    @Override
    public Page<Enseignant> getAllEnseignantParPage(int page, int size) {
        return enseignantRepository.findAll(PageRequest.of(page, size));
    }
}