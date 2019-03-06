package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ScheduleBackupTest {
	int year = 2019, month = 3, day = 6, hour = 9, minute = -1, dateEnd = 3;
	String taskName ="Name1", dbName ="EMS";
	DatabaseType databaseType = DatabaseType.SQLServer;

	@BeforeClass
	public static void prepareForAllTest() {
		new ScheduleBackup();
	}

	@Test
	public void scheduleBackupTrue() {
		boolean checkBool = ScheduleBackup.createTimeBackup(year, month, day, hour, minute, dateEnd, taskName, dbName, databaseType);
		assertEquals(true, checkBool);
	}

	@Test
	public void scheduleBackupFalse() {
		boolean checkBool = ScheduleBackup.createTimeBackup(year, month, day, hour, minute, dateEnd, taskName, dbName, databaseType);
		assertNotEquals(false, checkBool);
	}
}
