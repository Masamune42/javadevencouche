package fr.eni.demoJdbc.dal;

import java.util.List;

import fr.eni.demoJdbc.bo.Stagiaire;

public interface StagiaireDAO {

	List<Stagiaire> selectAll();
	
}
