package fr.eni.papeterie.dal;

public class DAOFactory {
	public static ArticleDAO getArticleDAO() {
		String impl = Settings.getProperty("implementationArticleDAO");
		ArticleDAO dao=null;
		try {
			dao = (ArticleDAO) Class.forName(impl).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao;
		//return new ArticleDAOJdbcImpl();

	}
}
