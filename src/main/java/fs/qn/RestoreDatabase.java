package fs.qn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class RestoreDatabase {
	public boolean restoreDBMySQL(String dbName) {
		try {
			DBConfig.createDB(dbName);

			String executeCmd = "mysql -u" + GetDataConfig.dbUser + " -p" + GetDataConfig.dbPass + " --database "
					+ dbName + " -s < " + GetDataConfig.savePath;
			System.out.println(executeCmd);
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", executeCmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}

			return true;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}

	}
	public boolean restoreDBSQLServer() {
		try {
//			DBConfig.createDB(dbName);
//			String executeCmd ="SQLCMD -E -S "  + GetDataConfig.dbMyServer + " –Q /"RESTORE DATABASE "
//					+ GetDataConfig.dbNameSV + " FROM DISK=" + "'" + GetDataConfig.PathSV + "'” ";
			String executeCmd ="SQLCMD -S " + GetDataConfig.dbMyServer + " -Q \"restore database " + GetDataConfig.dbNameSV + " from disk='" + GetDataConfig.PathSV + "' with stats=10\"";
			System.out.println(executeCmd);
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", executeCmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		RestoreDatabase database = new RestoreDatabase();
//		database.restoreDBMySQL("OKmen");
		database.restoreDBSQLServer();
	}

}
