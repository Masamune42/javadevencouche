package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {
	//Attribut
	private ArticleDAO daoArticle ;
	
	//Constructeurs
	public CatalogueManager() {
		daoArticle = DAOFactory.getArticleDAO();
	}

	/*
	 * Description : Ajouter un article au catalogue 
	 * Paramètre : article à ajouter
	 */
	public void addArticle(Article art) throws BLLException {

		validerArticle(art);
		
		try {
			daoArticle.insert(art);
		} catch (DALException e) {
			throw new BLLException("Erreur ajouter article " + art.toString() , e);
		}
		
	}

	/**
	 * Valider les données d'un article
	 * @param a
	 * @throws BLLException
	 */
	private void validerArticle(Article a) throws BLLException
	{
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		
		if(a==null){
			throw new BLLException("Article null");
		}
		//Les attributs des articles sont obligatoires
		if(a.getReference()==null || a.getReference().trim().length()==0){
			sb.append("La reference article est obligatoire.\n");
			valide = false;
		}
		if(a.getMarque()==null || a.getMarque().trim().length()==0){
			sb.append("La marque  est obligatoire.\n");
			valide = false;
		}
		if(a.getDesignation()==null || a.getDesignation().trim().length()==0){
			sb.append("La designation  est obligatoire.\n");
			valide = false;
		}
		if(a instanceof Ramette && ((Ramette)a).getGrammage()<=0){
			sb.append("Le grammage doit avoir une valeur positive.\n");
			valide = false;
		}
		if(a instanceof Stylo ){
			Stylo s = (Stylo) a;
			if(s.getCouleur()==null || s.getCouleur().trim().length()==0){
				sb.append("La couleur pour un stylo  est obligatoire.\n");
				valide = false;
			}
		}
		
		if(!valide){
			throw new BLLException(sb.toString());
		}

	}

	public List<Article> getCatalogue() throws BLLException{
		
		List<Article> articles;
		try {
			articles = daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur getCatalogue", e);
		}
		
		
		return articles;
	}

	public void updateArticle(Article art) throws BLLException{
		validerArticle(art);
		
		try {
			daoArticle.update(art);
		} catch (DALException e) {
			throw new BLLException("Erreur modification article " + art.toString() , e);
		}
	}

	/*
	 * 
	 */
	public void removeArticle(Integer idArticle) throws BLLException{
		try {
			daoArticle.delete(idArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur suppression article " + idArticle , e);
		}
		
	}

	
	
}
