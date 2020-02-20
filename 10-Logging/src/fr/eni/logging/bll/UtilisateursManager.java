package fr.eni.logging.bll;

import fr.eni.logging.dal.UtilisateurDAO;
import fr.eni.logging.dal.jdbc.UtilisateurDAOJdbcImpl;

public class UtilisateursManager {
	private UtilisateurDAO daoUtilisateur;

	public UtilisateursManager() {
		daoUtilisateur = new UtilisateurDAOJdbcImpl();
	}

	public boolean verifierUtilisateur(String id, String mdp) {
		return daoUtilisateur.verifierUtilisateur(id, mdp);

	}
}
