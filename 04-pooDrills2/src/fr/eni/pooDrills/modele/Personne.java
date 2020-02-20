package fr.eni.pooDrills.modele;

public class Personne {

	private int noPersonne;

	private String nom;

	public Personne(int noPersonne, String nom) {
		super();
		this.noPersonne = noPersonne;
		this.nom = nom;
	}

//	public boolean equals(Personne p) {
//		return p.nom.equals(this.nom) && p.noPersonne == this.noPersonne;
//
//	}
	
	@Override
	public boolean equals(Object obj) {
		boolean resultat = false;
		if(obj != null && obj instanceof Personne) {
			Personne pers = (Personne) obj;
			if (pers.getNom().equals(this.nom)
					&& pers.getNoPersonne() == this.noPersonne) {
				resultat = true;
			}
		}
		return resultat;
	}

	@Override
	public String toString() {
		return "Personne [noPersonne=" + noPersonne + ", nom=" + nom + "]";
	}

	public int getNoPersonne() {
		return noPersonne;
	}

	public void setNoPersonne(int noPersonne) {
		this.noPersonne = noPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
