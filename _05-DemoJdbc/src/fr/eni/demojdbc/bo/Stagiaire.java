package fr.eni.demojdbc.bo;

import java.time.LocalDate;

public class Stagiaire {

	private int noStagiaire;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String motDePasse;

	public Stagiaire() {
		// TODO Auto-generated constructor stub
	}

	public Stagiaire(int noStagiaire, String nom, String prenom, LocalDate dateDeNaissance, String motDePasse) {
		super();
		this.noStagiaire = noStagiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}

	public int getNoStagiaire() {
		return noStagiaire;
	}

	public void setNoStagiaire(int noStagiaire) {
		this.noStagiaire = noStagiaire;
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

	public void setDateNaissance(LocalDate dateDeNaissance) {
		this.dateNaissance = dateDeNaissance;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stagiaire [noStagiaire=");
		builder.append(noStagiaire);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append("]");
		return builder.toString();
	}

	

}
