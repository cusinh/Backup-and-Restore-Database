package fs.qn;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BackupTable {

	public static boolean Backupdbtosql(String dbTable) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = simpleDateFormat.format(cal.getTime());
		String name = "\\" + date1.replace(":", ".").replace(" ", "_") + ".sql";
		String executeCmd = GetDataConfig.sqlPath + "mysqldump -u " + GetDataConfig.dbUser + " -p" + GetDataConfig.dbPass
				+ " --database " + GetDataConfig.dbName + " --table " + dbTable + " -r " + GetDataConfig.savePath + name;
		System.out.println("About to execute " + executeCmd);
		try {
			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);

			InputStream is = runtimeProcess.getInputStream();
			int ch;
			while ((ch = is.read()) != -1) {
				System.out.write(ch);

			}
			InputStream err = runtimeProcess.getErrorStream();
			while ((ch = err.read()) != -1) {
				System.out.write(ch);
			}
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
}
