package fr.eni.papeterie.dal.jdbc;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.DALException;

public class TestSelectByMotCle {

	public static void main(String[] args) {
		
		ArticleDAOJdbcImpl dao = new ArticleDAOJdbcImpl();
		
		try {
			List<Article> articles = dao.selectByMotCle("bille");
			for(Article a:articles) {
				System.out.println(a);
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Article> articles = dao.selectByMarque("Stypen");
			for(Article a:articles) {
				System.out.println(a);
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
