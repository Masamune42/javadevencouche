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
		if(instance == null) {
			instance = new CatalogueManager();
		}
		
		return instance;
	}

	public List<Article> getCatalogue() throws BLLException {
		
		try {
			return daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de l'obtention du catalogue - ",e);
		}

	}

	public void addArticle(Article article) throws BLLException {
		try {
			validerArticle(article);
			daoArticle.insert(article);
		} catch (DALException e) {
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
		if (article.getDesignation() == null || article.getReference() == null || article.getMarque() == null
				|| article.getPrixUnitaire() < 0 || article.getQteStock() < 0) {
			throw new BLLException();
		}
		
		if(article instanceof Stylo && ((Stylo) article).getCouleur() == null) {
			throw new BLLException();
		}
		
		if(article instanceof Ramette && ((Ramette) article).getGrammage() < 0) {
			throw new BLLException();
		}
	}

	public void getArticle(int index) throws BLLException {
		try {
			daoArticle.selectById(index);
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
