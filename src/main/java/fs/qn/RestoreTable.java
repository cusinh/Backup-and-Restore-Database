package fs.qn;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Scanner;

public class RestoreTable {
	public static boolean restoreTableFromSQL(String tbName) {
		try {

			String executeCmd = "mysql -u " + GetDataConfig.dbUser + " -p" + GetDataConfig.dbPass 
					+ " --database " + GetDataConfig.dbName + " --table " + tbName
					+ " -s" + " < " + GetDataConfig.savePath;
			// System.out.println("About to execute " + executeCmd);.

			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			Scanner stdin = new Scanner(runtimeProcess.getInputStream());
			while (stdin.hasNextLine()) {
				stdin.nextLine();
			}
			stdin.close();
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 1) {
				return true;
			} else {
				return false;
			}

		} catch (IOException | InterruptedException | HeadlessException ex) {
			return false;
		}

	}
}
