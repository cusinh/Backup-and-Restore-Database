package fs.qn;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Scanner;

public class RestoreDatabase {
	public static boolean restoreDbFromSQL() {
		try {

			/* NOTE: Creating Database Constraints */

			String executeCmd = "mysql -u " + GetDataConfig.dbUser + " -p" + GetDataConfig.dbPass 
					+ " --database " + GetDataConfig.dbName + " -s" + " < " + GetDataConfig.savePath;
//			System.out.println("About to execute " + executeCmd);

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

		} catch (IOException | HeadlessException | InterruptedException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
}
