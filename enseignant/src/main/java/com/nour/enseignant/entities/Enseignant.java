package com.nour.enseignant.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEnseignant;

    public long getIdEnseignant() {
		return idEnseignant;
	}


	public void setIdEnseignant(long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}


	private String nomEnseignant;

    private String villeEnseignant; 

    private Date dateNaissance;

    
	public Enseignant() {
		super();
	}


	public Enseignant(String nomEnseignant, String villeEnseignant, Date dateNaissance) {
		super();

		this.nomEnseignant = nomEnseignant;
		this.villeEnseignant = villeEnseignant;
		this.dateNaissance = dateNaissance;
	}


	public String getNomEnseignant() {
		return nomEnseignant;
	}


	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}


	public String getVilleEnseignant() {
		return villeEnseignant;
	}


	public void setVilleEnseignant(String villeEnseignant) {
		this.villeEnseignant = villeEnseignant;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant + ", villeEnseignant="
				+ villeEnseignant + ", dateNaissance=" + dateNaissance + "]";
	}
    
    
    
}
