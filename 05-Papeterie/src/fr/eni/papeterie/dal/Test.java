package fr.eni.papeterie.dal;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

public class Test {

	public static void main(String[] args) {
		ArticleDAOJdbcImpl dao = new ArticleDAOJdbcImpl();
		Article a5 = new Stylo( "Bic5", "BBOrange2","Bic bille Orange", 1.2f, 20, "bleu");
		
		try {
			dao.insert(a5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		a5.setReference("Bic557");
		a5.setMarque("BBO");
		
		try {
			dao.update(a5);
			dao.selectAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
