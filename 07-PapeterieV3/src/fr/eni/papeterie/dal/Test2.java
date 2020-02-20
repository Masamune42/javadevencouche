package fr.eni.papeterie.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class Test2 {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PAPETERIE_BDD_PSQL", "postgres", "Pa$$w0rd")) {
			 
            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver"); 
 
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.Articles");
            Article article = null;
    		List<Article> articles = new ArrayList<>();
            while (rs.next()) {
    			 System.out.println(rs.getString("type").trim().equals("stylo"));
    			if (rs.getString("type").trim().equals("stylo")) {
    				article = new Stylo(rs.getInt("idArticle"), rs.getString("reference").trim(), rs.getString("marque"),
    						rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
    						rs.getString("couleur"));
    				articles.add(article);
    			} else if (rs.getString("type").trim().equals("ramette")) {
    				article = new Ramette(rs.getInt("idArticle"), rs.getString("reference"), rs.getString("marque"),
    						rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
    						rs.getInt("grammage"));
    				articles.add(article);
    			}
            }
            
            for (Article article2 : articles) {
				System.out.println(article2);
			}
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

	}

}
