package com.nour.enseignant.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nour.enseignant.entities.Enseignant;
import com.nour.enseignant.services.EnseignantService;

import java.util.List;

@Controller
public class EnseignantController {
    @Autowired
    EnseignantService enseignantService;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createEnseignant";
    }

    @GetMapping("/saveEnseignant")
    public String saveEnseignant(@ModelAttribute("Enseignant") Enseignant enseignant, @RequestParam("date") String date,
            ModelMap modelMap) throws ParseException {
        // conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance = dateformat.parse(String.valueOf(date));
        enseignant.setDateNaissance(dateNaissance);

        Enseignant saveEnseignant = enseignantService.saveEnseignant(enseignant);
        String msg = "Enseignant enregistré avec Id " + saveEnseignant.getIdEnseignant();
        modelMap.addAttribute("msg", msg);
        return "createEnseignant";
    }

    @GetMapping("/listeEnseignants")
    public String listeEnseignants(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        Page<Enseignant> enseignants = enseignantService.getAllEnseignantParPage(page, size);
        modelMap.addAttribute("enseignants", enseignants);
        modelMap.addAttribute("pages", new int[enseignants.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeEnseignant";
    }

    @GetMapping("/supprimerEnseignant")
    public String supprimerEnseignant(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        enseignantService.deleteEnseignantById(id);
        Page<Enseignant> enseignants = enseignantService.getAllEnseignantParPage(page, size);
        modelMap.addAttribute("enseignants", enseignants);
        modelMap.addAttribute("pages", new int[enseignants.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeEnseignant";
    }

    @GetMapping("/modifierEnseignant")
    public String editerEnseignant(@RequestParam("id") Long id, ModelMap modelMap) {
        Enseignant e = enseignantService.getEnseignant(id);
        modelMap.addAttribute("enseignant", e);
        return "editerEnseignant";
    }
    @GetMapping("/updateEnseignant")
    public String updateEnseignant(@ModelAttribute("enseignant") Enseignant enseignant, ModelMap modelMap) 
    {
    	enseignantService.updateEnseignant(enseignant);
    	List<Enseignant> enseignants = enseignantService.getAllEnseignant();
    	modelMap.addAttribute("enseignants", enseignants);
    	return "listeEnseignant";
    }
}