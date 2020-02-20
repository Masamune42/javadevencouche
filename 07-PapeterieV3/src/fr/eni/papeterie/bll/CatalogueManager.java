package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {
	private ArticleDAO daoArticle;
	private static CatalogueManager instance;

	private CatalogueManager() {
		daoArticle = DAOFactory.getArticleDAO();
	}

	public static CatalogueManager getInstance() {
		if (instance == null) {
			instance = new CatalogueManager();
		}

		return instance;
	}

	public List<Article> getCatalogue() throws BLLException {

		try {
			return daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de l'obtention du catalogue - ", e);
		}

	}

	public void addArticle(Article article) throws BLLException, BLLReferenceEnDoubleEception {
		try {
			validerArticle(article);
			daoArticle.insert(article);
		} catch (DALException e) {
			if (e.getCause().getMessage().contains("UK_REFERENCE")) {
				throw new BLLReferenceEnDoubleEception();
			}
			throw new BLLException("Echec de l'ajout d'article - ", e);
		}
	}

	public void updateArticle(Article article) throws BLLException {

		try {
			validerArticle(article);
			daoArticle.update(article);
		} catch (DALException e) {
			throw new BLLException("Echec de la modification de l'article - ", e);
		}
	}

	public void removeArticle(int index) throws BLLException {
		try {
			daoArticle.delete(index);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'article - ", e);
		}
	}

	public void validerArticle(Article article) throws BLLException {
		String listeErreurs = "";
		if (article.getDesignation().trim().isEmpty()) {
			listeErreurs += "Désignation vide\n";
		}

		if (article.getReference().trim().isEmpty()) {
			listeErreurs += "Référence vide\n";
		}
		
		if (article.getMarque().trim().isEmpty()) {
			listeErreurs += "Marque vide\n";
		}
		if (article.getPrixUnitaire() < 0 ) {
			listeErreurs += "Prix négatif\n";
		}
		if (article.getQteStock() < 0) {
			listeErreurs += "Quantité négative\n";
		}

		if (article instanceof Stylo && ((Stylo) article).getCouleur().isEmpty()) {
			listeErreurs += "Aucune couleur\n";
		}

		if (article instanceof Ramette && ((Ramette) article).getGrammage() < 0) {
			listeErreurs += "Aucune ramette cochée\n";
		}
		
		if(listeErreurs != "") {
			throw new BLLException(listeErreurs);
		}
	}

	public Article getArticle(int index) throws BLLException {
		try {
			return daoArticle.selectById(index);
		} catch (DALException e) {
			throw new BLLException("Echec de l'obtention de l'article - ", e);
		}
	}

	public void raz() throws BLLException {
		try {
			daoArticle.vidage();
		} catch (Exception e) {
			throw new BLLException("Echec de vidage de la table des Articles - ", e);
		}
	}

}
