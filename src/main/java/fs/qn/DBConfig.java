package fs.qn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {

	private static Statement statement;
	public static Connection conn = null;

	public static void createDB(String dbName) throws SQLException {
		conn = getConnection();
		statement = conn.createStatement();
		statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
		System.out.println("Created database " + dbName + "!");
	}

	public static Connection getConnection() {
		String HostUrl = null;
		try {
			HostUrl = GetDataConfig.dbUrl;
			Class.forName(GetDataConfig.dbDriver).newInstance();
			conn = DriverManager.getConnection(HostUrl, GetDataConfig.dbUser, GetDataConfig.dbPass);
			if (conn != null) {
				System.out.println("Connect Success!");
			}
			return conn;
		} catch (Exception ex) {
			try {
				conn.close();
				conn = null;
			} catch (Exception e) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*
		 * Class.forName(GetDataConfig.dbDriver).newInstance(); conn =
		 * DriverManager.getConnection(GetDataConfig.dbUrl, GetDataConfig.dbUser,
		 * GetDataConfig.dbPass); statement = conn.createStatement();
		 * statement.executeUpdate("CREATE DATABASE po");
		 */

		createDB("iphone");
	}

}
