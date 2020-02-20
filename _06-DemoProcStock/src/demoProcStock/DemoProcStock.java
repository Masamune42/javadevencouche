package demoProcStock;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DemoProcStock {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement callStmt = null;
		try {
			DriverManager.registerDriver(new SQLServerDriver());

			String url = "jdbc:sqlserver://127.0.0.1;databasename=BDD_DEMO";
			con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

			String sql = "{ call dbo.insertStagiaire( ?, "
					+ "?, ?, ?, ?) }";
			callStmt = con.prepareCall(sql);
			callStmt.setString(1, "Nordine");
			callStmt.setString(2, "NATEUR");
			callStmt.setDate(3, java.sql.Date.valueOf(LocalDate.of(1980, 01, 01)));
			callStmt.setString(4, "azerty");
			callStmt.registerOutParameter(5, Types.INTEGER);
			
			//Execution de la proc stock
			callStmt.execute();
			
			System.out.println("idPersonne =" + callStmt.getInt(5));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
