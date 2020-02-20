package fr.eni.demoJdbc.dal;

public class DAOFactory {

	public static StagiaireDAO getStagiaireDAO(){
		String impl = Settings.getProperty("implementationStagiaireDAO");
		StagiaireDAO dao=null;
		try {
			dao = (StagiaireDAO) Class.forName(impl).newInstance();
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
		//return new StagiaireDAOImpl();
	}
	
}
