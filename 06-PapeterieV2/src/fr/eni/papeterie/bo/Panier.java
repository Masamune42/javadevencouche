package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private float montant;
	private List<Ligne> lignesPanier = new ArrayList<>();

	public Panier() {
		// TODO Auto-generated constructor stub
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public List<Ligne> getLignes() {
		return lignesPanier;
	}

	public void setLignes(List<Ligne> lignes) {
		this.lignesPanier = lignes;
	}

	public void addLigne(Article article, int qte) {
		lignesPanier.add(new Ligne(qte, article));

	}

	public void updateLigne(int index, int newQte) {
		lignesPanier.get(index).setQte(newQte);
	}

	public void removeLigne(int index) {
		lignesPanier.remove(index);
		
	}

	public Ligne getLigne(int index) {
		return lignesPanier.get(index);
	}

	@Override
	public String toString() {
		String ts="Panier :\n";
		for (Ligne ligne : lignesPanier) {
			ts+="\nligne "+ lignesPanier.indexOf(ligne) +" :    "+ ligne.toString();
		}
		ts+="\n\nValeur du panier : " + montant;
		return ts;
	}
	
	

}
