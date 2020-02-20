package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class ArticleDAOJdbcImplPostgres {
	Connection con = null;

	private Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB";
		// Connection con = null;
		con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
		return con;

	}

	public Article selectById(int idArticle) throws SQLException {
		// Etape 1 : Charger le driver JDBC
		//DriverManager.deregisterDriver(new SQLServerDriver());

		// Etape 2 : Créer une connexion
		String url = "jdbc:postgresql://localhost:5432/PAPETERIE_BDD_PSQL";
		con = DriverManager.getConnection(url, "postgres", "Pa$$w0rd");
		
		

		// Utilisation de la connexion
		// Etape 3 :
		Statement stmt = con.createStatement();
		// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
		String sql = "SELECT * FROM Articles WHERE idArticle=" + idArticle;

		// Contient un tableau de requête + un curseur qui indique la ligne
		// position de base du curseur : avant la 1ère ligne
		ResultSet rs = stmt.executeQuery(sql);
		Article article = null;
		// rs.next : renvoie true si on a une prochaine ligne
		boolean trouve = false;
		while (rs.next() && !trouve) {
			// System.out.println(rs.getString("type").trim().equals("stylo"));
			if (rs.getString("type").trim().equals("stylo")) {
				article = new Stylo(rs.getInt("idArticle"), rs.getString("reference"), rs.getString("marque"),
						rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
						rs.getString("couleur"));
				trouve = true;
			} else if (rs.getString("type").trim().equals("ramette")) {
				article = new Ramette(rs.getInt("idArticle"), rs.getString("reference"), rs.getString("marque"),
						rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
						rs.getInt("grammage"));
				trouve = true;
			}

		}
		con.close();
		return article;
	}

	public List<Article> selectAll() throws SQLException {
		// Etape 1 : Charger le driver JDBC

		// Etape 2 : Créer une connexion
		String url = "jdbc:postgresql://localhost:5432/PAPETERIE_BDD_PSQL";
		con = DriverManager.getConnection(url, "postgres", "Pa$$w0rd");

		// Utilisation de la connexion
		// Etape 3 :
		Statement stmt = con.createStatement();
		// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
		String sql = "SELECT * FROM Articles";

		// Contient un tableau de requête + un curseur qui indique la ligne
		// position de base du curseur : avant la 1ère ligne
		ResultSet rs = stmt.executeQuery(sql);
		Article article = null;
		List<Article> articles = new ArrayList<>();
		// rs.next : renvoie true si on a une prochaine ligne
		while (rs.next()) {
			// System.out.println(rs.getString("type").trim().equals("stylo"));
			if (rs.getString("type").trim().equals("stylo")) {
				article = new Stylo(rs.getInt("idArticle"), rs.getString("reference"), rs.getString("marque"),
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
		con.close();
		return articles;
	}

	public void insert(Article article) throws SQLException {

		// Etape 1 : Charger le driver JDBC

		// Etape 2 : Créer une connexion
		String url = "jdbc:postgresql://localhost:5432/PAPETERIE_BDD_PSQL";
		con = DriverManager.getConnection(url, "postgres", "Pa$$w0rd");
		// Utilisation de la connexion
		// Etape 3 :
		String sql = "INSERT INTO Articles (reference,marque,designation, prixUnitaire,qteStock,grammage,couleur,type) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
		stmt.setString(1, article.getReference());
		stmt.setString(2, article.getMarque());
		stmt.setString(3, article.getDesignation());
		stmt.setFloat(4, article.getPrixUnitaire());
		stmt.setInt(5, article.getQteStock());
		if (article instanceof Stylo) {
			stmt.setNull(6, java.sql.Types.INTEGER);
			stmt.setString(7, ((Stylo) article).getCouleur());
			stmt.setString(8, "stylo");
		} else if (article instanceof Ramette) {
			stmt.setInt(6, ((Ramette) article).getGrammage());
			stmt.setNull(7, java.sql.Types.VARCHAR);
			stmt.setString(8, "ramette");
		}
		
		stmt.executeUpdate();

		try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				article.setIdArticle(generatedKeys.getInt(1));
			} else {
				throw new SQLException("ERROR");
			}
		}
		con.close();

	}

	public void update(Article article) throws SQLException {

		// Etape 1 : Charger le driver JDBC

		// Etape 2 : Créer une connexion
		String url = "jdbc:postgresql://localhost:5432/PAPETERIE_BDD_PSQL";
		con = DriverManager.getConnection(url, "postgres", "Pa$$w0rd");
		// Utilisation de la connexion
		// Etape 3 :
		String sql = "";
		if (article instanceof Stylo) {
			sql = "UPDATE Articles SET reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, couleur=? WHERE idArticle=?";
		} else if (article instanceof Ramette) {
			sql = "UPDATE Articles SET reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=? WHERE idArticle=?";
		}

		PreparedStatement stmt = con.prepareStatement(sql);
		// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
		stmt.setString(1, article.getReference());
		stmt.setString(2, article.getMarque());
		stmt.setString(3, article.getDesignation());
		stmt.setFloat(4, article.getPrixUnitaire());
		stmt.setInt(5, article.getQteStock());
		if (article instanceof Stylo) {
			stmt.setString(6, ((Stylo) article).getCouleur());
		} else if (article instanceof Ramette) {
			stmt.setInt(6, ((Ramette) article).getGrammage());
		}

		stmt.setInt(7, article.getIdArticle());

		stmt.executeUpdate();

		con.close();

	}

	public void delete(int idArticle) throws SQLException {
		// Etape 1 : Charger le driver JDBC

		// Etape 2 : Créer une connexion
		String url = "jdbc:postgresql://localhost:5432/PAPETERIE_BDD_PSQL";
		con = DriverManager.getConnection(url, "postgres", "Pa$$w0rd");

		// Utilisation de la connexion
		// Etape 3 :
		String sql = "DELETE FROM Articles WHERE idArticle=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
		stmt.setInt(1, idArticle);

		stmt.executeUpdate();

		con.close();

	}
}
