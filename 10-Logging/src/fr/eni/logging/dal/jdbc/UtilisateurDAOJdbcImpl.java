package fr.eni.logging.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.logging.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	static {
		try {
			DriverManager.deregisterDriver(new SQLServerDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifierUtilisateur(String id, String mdp) {
		try (Connection con = JdbcTools.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Utilisateurs WHERE identifiant=? AND mdp=?");

			stmt.setString(1, id);
			stmt.setString(2, mdp);

			return stmt.executeQuery().next();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

}
