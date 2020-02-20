package fr.eni.demoJdbc.test;

import java.util.List;

import fr.eni.demoJdbc.bo.Stagiaire;
import fr.eni.demoJdbc.dal.DAOFactory;
import fr.eni.demoJdbc.dal.StagiaireDAO;
//import fr.eni.demoJdbc.dal.sqlServer.StagiaireDAOImpl;

public class TestDAL {

	public static void main(String[] args) {

		//StagiaireDAOImpl daoArticle = new StagiaireDAOImpl(); //Dependance forte
		//StagiaireDAO daoArticle = new StagiaireDAOImpl();
		StagiaireDAO daoArticle = DAOFactory.getStagiaireDAO(); 
				
		List<Stagiaire> stagiaires =daoArticle.selectAll();
		
		System.out.println(stagiaires);
		
		
		
	}

}
