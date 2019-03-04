package fs.qn;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BackupDatabase {

	public boolean export() {
		String path2 = GetDataConfig.savePath + "\\" + getNameFile_VersionAndDate() + ".sql";
		String dumpCommand = GetDataConfig.sqlPath+ "mysqldump -u " + GetDataConfig.dbUser + " -p" + GetDataConfig.dbPass + " --add-drop-database -B " + GetDataConfig.dbName
				+ " -r " + path2;
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
	
	public static String getNameFile_VersionAndDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = simpleDateFormat.format(cal.getTime());
		String nameFile = "version1_";
		File dir = new File(GetDataConfig.savePath);
		
        File[] children = dir.listFiles();
        // check null
        if(children.equals(null) || children == null || children.length == 0) {
        	return nameFile + date1.replace(":", ".").replace(" ", "_");
        }
        
        for (File file : children) {
        	String string = file.getName().substring(0, 8);
            if(nameFile.substring(0,8).equals(string)) {
            	int count = Integer.parseInt(nameFile.substring(7,8));
            	count++;
            	nameFile = nameFile.replace(nameFile.substring(7,8), String.valueOf(count));
            }
        }
        
		return nameFile + date1.replace(":", ".").replace(" ", "_");
	}
}
