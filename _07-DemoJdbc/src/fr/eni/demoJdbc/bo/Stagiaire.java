package fr.eni.demoJdbc.bo;

import java.time.LocalDate;

public class Stagiaire {
	
	private int noStagiaire;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String motDePasse;
	
	public Stagiaire() {
		
	}
	
	public Stagiaire(String nom, String prenom, LocalDate dateNaissance, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.motDePasse = motDePasse;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	
	public int getNoStagiaire() {
		return noStagiaire;
	}

	public void setNoStagiaire(int noStagiaire) {
		this.noStagiaire = noStagiaire;
	}

	@Override
	public String toString() {
		return "Stagiaire [noStagiaire=" + noStagiaire + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", motDePasse=" + motDePasse + "]";
	}
	
	
}
