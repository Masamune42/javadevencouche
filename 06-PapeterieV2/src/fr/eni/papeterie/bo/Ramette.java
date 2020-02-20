package fr.eni.papeterie.bo;

public class Ramette extends Article {
	private int grammage;

	public Ramette(int idArticle, String marque, String refence, String designation, float prixUnitaire, int qteStock,
			int grammage) {
		super(idArticle, marque, refence, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	public Ramette(String marque, String refence, String designation, float prixUnitaire, int qteStock, int grammage) {
		super(marque, refence, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	@Override
	public String toString() {
		return super.toString() + " Ramette [grammage=" + grammage + "]";
	}

}
