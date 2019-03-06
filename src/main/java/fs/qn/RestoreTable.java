package fs.qn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class RestoreTable {
	public static boolean Restore(String tbName) throws IOException, InterruptedException, SQLException {
		String executeCmd = "mysql -u" + GetDataConfig.dbUser + " -p" + GetDataConfig.dbPass + " --database " + GetDataConfig.dbName 
				+ " --table " + GetDataConfig.tbName + " -s < " + GetDataConfig.savePath; 
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
	}

}