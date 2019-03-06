package fs.qn;

import java.util.Date;
import java.util.TimerTask;

public class ScheduleTask extends TimerTask {
	private String nameTask;
	private String dbName;
	private DatabaseType databaseType;

	public ScheduleTask(String nameTask, String dbName, DatabaseType databaseType) {
		this.nameTask = nameTask;
		this.dbName = dbName;
		this.databaseType = databaseType;
	}

	BackupDatabase backupDatabase = new BackupDatabase();

	@Override
	public void run() {
		switch (databaseType) {
		case MySQL:
			BackupDatabase.backupDBMySql(nameTask + dbName, GetDataConfig.savePath);
			break;
		case Oracle:
			System.out.println("Task Oracle");
			break;
		case PostgreSQL:
			System.out.println("Task PostgreSQL");
			break;
		case SQLServer:
			BackupDatabase.backupDBSqlServer(GetDataConfig.dbMyServer, nameTask + dbName, GetDataConfig.savePathSV);
			break;
		}
	}
}
