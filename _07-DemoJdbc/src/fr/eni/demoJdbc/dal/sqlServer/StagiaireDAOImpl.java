package fr.eni.demoJdbc.dal.sqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.demoJdbc.bo.Stagiaire;
import fr.eni.demoJdbc.dal.JdbcTools;

public class StagiaireDAOImpl {

	public static void main(String[] args)  {
		Connection con=null;
		try {
			//Etape 1 : Charger le driver JDBC
//			DriverManager.registerDriver(new SQLServerDriver());
			
			//Etape 2 : Créer une connexion
//			String url = "jdbc:sqlserver://127.0.0.1;databasename=BDD_DEMO";
//			con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
			con = JdbcTools.getConnection();
			
			//Utilisation de la connexion
			//Etape 3 : 
			Statement stmt = con.createStatement();
			String sql = "SELECT noStagiaire" + 
					"      ,prenom" + 
					"      ,nom" + 
					"      ,dateDeNaissance" + 
					"      ,motDePasse" + 
					"  FROM Stagiaires ";
			ResultSet rs = stmt.executeQuery(sql);
			Stagiaire stagiaire = null;
			List<Stagiaire> stagiaires = new ArrayList();
			while(rs.next()) {
				stagiaire = new Stagiaire();
				//Traitement d'une ligne
				stagiaire.setNoStagiaire(rs.getInt("noStagiaire"));
				//stagiaire.setNoStagiaire(rs.getInt(1));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setNom(rs.getString("nom"));
				LocalDate dateNaissance = null;
				if(rs.getDate("dateDeNaissance")!=null) {
					dateNaissance = rs.getDate("dateDeNaissance").toLocalDate();
				}
				stagiaire.setDateNaissance(dateNaissance);
				stagiaire.setMotDePasse(rs.getString("motDePasse"));
				stagiaires.add(stagiaire);
				System.out.println(stagiaire);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
