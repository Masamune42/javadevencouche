package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public interface ArticleDAO {
	Article selectById(int id) throws DALException;

	List<Article> selectAll() throws DALException;

	void update(Article article) throws DALException;

	void insert(Article article) throws DALException;

	void delete(int id) throws DALException;

	List<Article> selectByMarque(String marque) throws DALException;

	List<Article> selectByMotCle(String motCle) throws DALException;
	
	void vidage() throws DALException;

}
