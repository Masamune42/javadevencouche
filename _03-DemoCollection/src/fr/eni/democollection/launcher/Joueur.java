package fr.eni.democollection.launcher;

public class Joueur {
	String nom;
	int numero;

	public Joueur(String nom, int numero) {
		this.nom = nom;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", numero=" + numero + "]";
	}
	
	

}
