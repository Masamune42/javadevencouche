package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;

public class ArticleDAOJdbcImpl {
	Connection con = null;

	// Constructeur
	public ArticleDAOJdbcImpl() {
		// Etape 1 : Charger le driver JDBC
		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB";
		Connection con = null;
		con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
		return con;

	}

	public Article selectById(int idArticle) throws DALException {
		Article article = null;
		// Etape 1 : Charger le driver JDBC
		// DriverManager.deregisterDriver(new SQLServerDriver());

		// Etape 2 : Créer une connexion
		// String url = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB";
		// con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

		// Utilisation de la connexion
		// Etape 3 :

		try (Connection con = getConnection();) {
			Statement stmt = con.createStatement();
			// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
			String sql = "SELECT * FROM Articles WHERE idArticle=" + idArticle;

			// Contient un tableau de requête + un curseur qui indique la ligne
			// position de base du curseur : avant la 1ère ligne
			ResultSet rs = stmt.executeQuery(sql);

			// rs.next : renvoie true si on a une prochaine ligne
			boolean trouve = false;
			while (rs.next() && !trouve) {
				// System.out.println(rs.getString("type").trim().equals("stylo"));
				if (rs.getString("type").trim().equals("stylo")) {
					article = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference"),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getString("couleur"));
					trouve = true;
				} else if (rs.getString("type").trim().equals("ramette")) {
					article = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference"),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getInt("grammage"));
					trouve = true;
				}

			}
		} catch (Exception e) {
			throw new DALException("Echec du selectById", e);
		}

		return article;
	}

	public List<Article> selectAll() {
		List<Article> articles = new ArrayList<>();
		// Etape 1 : Charger le driver JDBC
		// DriverManager.deregisterDriver(new SQLServerDriver());

		// Etape 2 : Créer une connexion
		// String url = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB";
		// con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

		// Utilisation de la connexion
		// Etape 3 :
		try (Connection con = getConnection();) {
			Statement stmt = con.createStatement();
			// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
			String sql = "SELECT * FROM Articles";

			// Contient un tableau de requête + un curseur qui indique la ligne
			// position de base du curseur : avant la 1ère ligne
			ResultSet rs = stmt.executeQuery(sql);
			Article article = null;

			// rs.next : renvoie true si on a une prochaine ligne
			while (rs.next()) {
				// System.out.println(rs.getString("type").trim().equals("stylo"));
				if (rs.getString("type").trim().equals("stylo")) {
					article = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference"),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getString("couleur"));
					articles.add(article);
				} else if (rs.getString("type").trim().equals("ramette")) {
					article = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference"),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getInt("grammage"));
					articles.add(article);
				}

			}
		} catch (SQLException e) {
			// TODO: handle exception
		}

		return articles;
	}

	public void insert(Article article) throws DALException {

		// Etape 1 : Charger le driver JDBC
//		DriverManager.deregisterDriver(new SQLServerDriver());
//
//		// Etape 2 : Créer une connexion
//		String url = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB";
//		con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
		// Utilisation de la connexion
		// Etape 3 :
		String sql = "INSERT INTO Articles VALUES(?,?,?,?,?,?,?,?)";

		try (Connection con = getConnection()) {
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

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				article.setIdArticle(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException();
		}

	}

	public void update(Article article) throws DALException {
		String sql = "";
		if (article instanceof Stylo) {
			sql = "UPDATE Articles SET marque=?, reference=?, designation=?, prixUnitaire=?, qteStock=?, couleur=? WHERE idArticle=?";
		} else if (article instanceof Ramette) {
			sql = "UPDATE Articles SET marque=?, reference=?, designation=?, prixUnitaire=?, qteStock=?, grammage=? WHERE idArticle=?";
		}
		// Etape 1 : Charger le driver JDBC
		// DriverManager.deregisterDriver(new SQLServerDriver());

		// Etape 2 : Créer une connexion
		// String url = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB";
		// con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
		// Utilisation de la connexion
		// Etape 3 :

		try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

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

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void delete(int idArticle) throws DALException {
		String sql = "DELETE FROM Articles WHERE idArticle=?";
		// Etape 1 : Charger le driver JDBC
		// DriverManager.deregisterDriver(new SQLServerDriver());

		// Etape 2 : Créer une connexion
		// String url = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB";
		// con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

		try (Connection con = getConnection();
				// Créer la requête SQL sur SQLServer avant de l'exécuter depuis java
				PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, idArticle);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		}

	}
}
