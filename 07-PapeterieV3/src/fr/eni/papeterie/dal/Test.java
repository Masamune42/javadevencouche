package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;

public class Test {

	public static void main(String[] args) {
		ArticleDAO dao = DAOFactory.getArticleDAO();
		
		Article a5 = new Stylo( "Bic5", "BBOrange2","Bic bille Orange", 1.2f, 20, "bleu");
		
		try {
			dao.insert(a5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		a5.setReference("Bic557");
//		a5.setMarque("BBO");
		
		try {
			//dao.update(a5);
			System.out.println("Tous :");
			List<Article> articles = dao.selectAll();
			afficherArticles(articles);
			System.out.println("Par marque : ");
			articles = dao.selectByMotCle("");
			afficherArticles(articles);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	private static void afficherArticles(List<Article> articles){
		StringBuffer sb = new StringBuffer();
		for(Article art: articles){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	

}
