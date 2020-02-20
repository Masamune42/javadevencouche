package fr.eni.pooDrills.modele;

public class Triangle extends Forme {
	//Attributs
	private float largeur;
	private float hauteur;
	
	
	
	public Triangle(float largeur, float hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	//Méthodes
	public float calculerSurface() {
		return largeur * hauteur / 2;
	}
	
	//Getters et Setters
	public float getLargeur() {
		return largeur;
	}
	
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}
	
	public float getHauteur() {
		return hauteur;
	}
	
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	@Override
	public String toString() {
		return "Triangle [largeur=" + largeur + ", hauteur=" + hauteur + "]";
	}

	

	
	
	
}
