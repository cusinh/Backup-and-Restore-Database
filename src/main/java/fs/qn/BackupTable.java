package fs.qn;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BackupTable {
	static List<String> dbTable = new ArrayList<String>();

	public static boolean backupDBtoMySql(String dbName, List<String> listDBTable, String savePath) {
		String nameTable1 = "";
		for (String nameTable : listDBTable) {
			nameTable1 = nameTable1.concat(nameTable + " ");
		}
		String name = "\\" + getNameFile_VersionAndDate(savePath) + ".sql";
		String executeCmd = GetDataConfig.sqlPath + "mysqldump -u " + GetDataConfig.dbUser + " -p"
				+ GetDataConfig.dbPass + " --database " + dbName + " --table " + nameTable1 + " -r " + savePath + name;
		System.out.println("About to execute " + executeCmd);
		try {
			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if(processComplete == 0) {
				System.out.println("Complete !!!");
				return true;
			}else {
				System.out.println("Failure !!!");
				return false;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}

	public static String getNameFile_VersionAndDate(String savePath) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date1 = simpleDateFormat.format(cal.getTime());
		String nameFile = "version1_";
		File dir = new File(savePath);

		File[] children = dir.listFiles();
		// check null
		if (children.equals(null) || children == null || children.length == 0) {
			return nameFile + date1.replace(":", ".").replace(" ", "_");
		}

		for (File file : children) {
			String string = file.getName().substring(0, 8);
			if (nameFile.substring(0, 8).equals(string)) {
				int count = Integer.parseInt(nameFile.substring(7, 8));
				count++;
				nameFile = nameFile.replace(nameFile.substring(7, 8), String.valueOf(count));
			}
		}

		return nameFile + date1.replace(":", ".").replace(" ", "_");
	}

//	public static boolean backupDBtoPostgreSql(String savePath, String dbTable, String dbName) {
//		String name = "\\" + getNameFile_VersionAndDate(savePath) + ".sql";
//		String executeCmd = GetDataConfig.sqlPathPostgre + "pg_dump.exe" + " -h " + GetDataConfig.dbHostP + " -U "
//				+ GetDataConfig.dbUserP + " --password=" + GetDataConfig.dbPassP + " -d " + dbName + " -t " + dbTable
//				+ " -F c -b -v -f " + savePath + name;
//		System.out.println("About to execute " + executeCmd);
//		try {
//			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
//
//			InputStream is = runtimeProcess.getInputStream();
//			int ch;
//			while ((ch = is.read()) != -1) {
//				System.out.write(ch);
//				System.out.println("Backup complete !!!");
//			}
//			InputStream err = runtimeProcess.getErrorStream();
//			while ((ch = err.read()) != -1) {
//				System.out.write(ch);
//			}
//			return true;
//		} catch (Exception exc) {
//			exc.printStackTrace();
//		}
//		return false;
//	}

//	public static boolean backupDBtoOrecal(String savePath, String dbTable, String dbName) {
//		String name = "\\" + getNameFile_VersionAndDate(savePath) + ".sql";
//		String executeCmd = GetDataConfig.sqlPathPostgre + "pg_dump.exe" + " -h " + GetDataConfig.dbHostP + " -U "
//				+ GetDataConfig.dbUserP + " --password=" + GetDataConfig.dbPassP + " -d " + dbName + " -t " + dbTable
//				+ " -F c -b -v -f " + savePath + name;
//		System.out.println("About to execute " + executeCmd);
//		try {
//			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
//
//			InputStream is = runtimeProcess.getInputStream();
//			int ch;
//			while ((ch = is.read()) != -1) {
//				System.out.write(ch);
//				System.out.println("Backup complete !!!");
//			}
//			InputStream err = runtimeProcess.getErrorStream();
//			while ((ch = err.read()) != -1) {
//				System.out.write(ch);
//			}
//			return true;
//		} catch (Exception exc) {
//			exc.printStackTrace();
//		}
//		return false;
//	}

	public static void main(String[] args) {
		List<String> listDBTable = new ArrayList<String>();
		listDBTable.add("skill");
		listDBTable.add("employee");
//		listDBTable.add("");
		backupDBtoMySql("ems", listDBTable, "C:\\Users\\Vinh\\Desktop\\TT");
//		backupDBtoPostgreSql("C:\\Users\\Vinh\\Desktop\\TT", "location", "test");
	}
}
