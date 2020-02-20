package fr.eni.papeterie.bo;

public abstract class Article {
	private int idArticle;
	private String marque;
	private String reference;
	private String designation;
	private float prixUnitaire;
	private int qteStock;

	

	public Article(int idArticle, String marque, String reference, String designation, float prixUnitaire,
			int qteStock) {
		this.idArticle = idArticle;
		this.marque = marque;
		this.reference = reference;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}
	
	

	public Article(String marque, String reference, String designation, float prixUnitaire, int qteStock) {
		this.marque = marque;
		this.reference = reference;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}



	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String refence) {
		this.reference = refence;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [idArticle=");
		builder.append(idArticle);
		builder.append(", marque=");
		builder.append(marque);
		builder.append(", reference=");
		builder.append(reference);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", prixUnitaire=");
		builder.append(prixUnitaire);
		builder.append(", qteStock=");
		builder.append(qteStock);
		builder.append("]");
		return builder.toString();
	}

	

}
