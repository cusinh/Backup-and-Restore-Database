package fs.qn;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BackupDatabase {

	public static String getNameFile_VersionAndDate(String dbName, String savePath) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = simpleDateFormat.format(cal.getTime());
		String nameVersion = "version1";
		String getNameFile = "db_" + dbName + "_" + nameVersion + "_" + date1.replace(":", ".").replace(" ", "_");
		File dir = new File(savePath);

		File[] children = dir.listFiles();
		if (children.equals(null) || children == null || children.length == 0) {
			return getNameFile;
		}

		// check null
		for (File file : children) {
			String[] cutNameFile = file.getName().split("_");
			for (String strings : cutNameFile) {
				if (strings.equals(nameVersion)) {
					int count = Integer.parseInt(strings.substring(strings.length() - 1));
					count++;
					nameVersion = nameVersion.replace(strings.substring(strings.length() - 1), String.valueOf(count));
				}
			}
		}
		getNameFile = "db_" + dbName + "_" + nameVersion + "_" + date1.replace(":", ".").replace(" ", "_");
		return getNameFile;
	}

	public boolean backupDBMySql(String dbName, String savePath) {
		String nameFile = getNameFile_VersionAndDate(dbName, savePath) + ".sql";
		String path2 = savePath + "\\" + nameFile;
		String dumpCommand = GetDataConfig.sqlPath + "\\" + "mysqldump -u " + GetDataConfig.dbUser + " -p"
				+ GetDataConfig.dbPass + " --add-drop-database -B " + dbName + " -r " + path2;
		Runtime rt = Runtime.getRuntime();
		File test = new File(path2);
		PrintStream ps;
		System.out.println(dumpCommand);
		try {
			Process child = rt.exec(dumpCommand);
			ps = new PrintStream(test);
			InputStream in = child.getInputStream();
			int ch;
			while ((ch = in.read()) != -1) {
				ps.write(ch);
				System.out.write(ch); // to view it by console
			}

			InputStream err = child.getErrorStream();
			while ((ch = err.read()) != -1) {
				System.out.write(ch);
			}
			return true;
		} catch (Exception exc) {
			System.out.println("The database does not exist and the problem is not correct");
		}
		return false;
	}

	public boolean backupDBSqlServer(String server, String dbName, String savePath) {
		String nameFile = getNameFile_VersionAndDate(dbName, savePath) + ".sql";
		String path3 = "SQLCMD -E -S " + server + " -Q \"BACKUP DATABASE " + dbName + " TO DISK=" + "\'" + savePath
				+ "\\" + nameFile + "\'\"";
		Runtime rt = Runtime.getRuntime();
		System.out.println(path3);
		try {
			Process child = rt.exec(path3);
			InputStream in = child.getInputStream();
			int ch;
			while ((ch = in.read()) != -1) {
				System.out.write(ch); // to view it by console
			}

			InputStream err = child.getErrorStream();
			while ((ch = err.read()) != -1) {
				System.out.write(ch);
			}
			return true;
		} catch (Exception exc) {
			System.out.println("The database does not exist and the problem is not correct");
		}
		return false;
	}
}
