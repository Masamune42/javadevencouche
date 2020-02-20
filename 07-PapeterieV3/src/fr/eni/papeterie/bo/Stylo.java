package fr.eni.papeterie.bo;

public class Stylo extends Article {

	private String couleur;
	
	public Stylo() {
		// TODO Auto-generated constructor stub
	}

	public Stylo(int idArticle, String marque, String refence, String designation, float prixUnitaire, int qteStock,
			String couleur) {
		super(idArticle, marque, refence, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	public Stylo(String marque, String refence, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(marque, refence, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return super.toString() + " Stylo [Couleur=" + couleur + "]";
	}

}
