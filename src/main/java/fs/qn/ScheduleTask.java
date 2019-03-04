package fs.qn;

import java.util.TimerTask;

public class ScheduleTask extends TimerTask {
	BackupDatabase backupDatabase = new BackupDatabase();
	@Override
	public void run() {
		// Call methods backup
		backupDatabase.export();
	}
}
