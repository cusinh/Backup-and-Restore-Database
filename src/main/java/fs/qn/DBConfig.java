package fs.qn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	public static Connection conn = null;

	public Connection getConnection() {
		String HostUrl = null;
		try {
			HostUrl = GetDataConfig.dbUrl + "/" + GetDataConfig.dbName;
			Class.forName(GetDataConfig.dbDriver).newInstance();
			conn = DriverManager.getConnection(HostUrl, GetDataConfig.dbUser, GetDataConfig.dbPass);
			if (conn != null) {
				System.out.println("Connect Success");
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

}
