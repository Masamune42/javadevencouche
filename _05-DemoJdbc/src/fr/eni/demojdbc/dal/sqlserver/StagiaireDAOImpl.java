package fr.eni.demojdbc.dal.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.demojdbc.bo.Stagiaire;

public class StagiaireDAOImpl {
	public static void main(String[] args) {
		Connection con = null;

		try {
			// Etape 1 : Charger le driver JDBC
			DriverManager.deregisterDriver(new SQLServerDriver());

			// Etape 2 : Créer une connexion
			String url = "jdbc:sqlserver://127.0.0.1;databasename=BDD_DEMO";
			con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

			// Utilisation de la connexion
			// Etape 3 :
			Statement stmt = con.createStatement();
			// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
			String sql = "SELECT noStagiaire" + "      ,prenom" + "      ,nom" + "      ,dateDeNaissance"
					+ "      ,motDePasse" + "  FROM Stagiaires ";

			// Contient un tableau de requête + un curseur qui indique la ligne
			// position de base du curseur : avant la 1ère ligne
			ResultSet rs = stmt.executeQuery(sql);
			Stagiaire stagiaire = null;
			List<Stagiaire> stagiaires = new ArrayList<>();
			// rs.next : renvoie true si on a une prochaine ligne
			while (rs.next()) {
				stagiaire = new Stagiaire();
				// Traitement d'une ligne
				stagiaire.setNoStagiaire(rs.getInt("noStagiaire"));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setNom(rs.getString("nom"));
				if (rs.getDate("dateDeNaissance") != null) {
					stagiaire.setDateNaissance(rs.getDate("dateDeNaissance").toLocalDate());
				}

				stagiaire.setMotDePasse(rs.getString("motDePasse"));
				stagiaires.add(stagiaire);
				System.out.println(stagiaire);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Vérifie si on a bien pu se connecter avant de fermer
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

	}
}
