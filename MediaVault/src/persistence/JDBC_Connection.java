package persistence;

import java.sql.*;

public class JDBC_Connection {
	/**
	 * Used for queries that result in a ResultSet
	 * @param query is the query that will be forwarded to the DB
	 * @return the ResultSet of values
	 */
	public static ResultSet getResult(String query) {
		String url = "jdbc:mysql://localhost:3306/mediavault";
		String user = "mediavaultadmin";
		String password = "0000";

		try {
			// create connection
			Connection con = DriverManager.getConnection(url, user, password);
			
			// create statement
			Statement statement = con.createStatement();
			
			// create resultset
			ResultSet result = statement.executeQuery(query);
			
			return result;
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Used for queries where no output is expected, only the success boolean
	 * @param query is the command to be executed
	 * @return true if successful, false otherwise
	 */
	public static boolean execute(String query) {
		String url = "jdbc:mysql://localhost:3306/mediavault";
		String user = "mediavaultadmin";
		String password = "0000";

		try {
			// create connection
			Connection con = DriverManager.getConnection(url, user, password);
			
			// create statement
			Statement statement = con.createStatement();
			
			// create resultset
			return statement.execute(query);
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return false;
	}
}