package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ScheduleBackupTest {
	int year = 2019, month = 3, day = 3, hour = 21, minute = 27, dateEnd = 3;

	@BeforeClass
	public static void prepareForAllTest() {
		new ScheduleBackup();
	}

	@Test
	public void scheduleBackupTrue() {
		boolean checkBool = ScheduleBackup.createTimeBackup(year, month, day, hour, minute, dateEnd);
		assertEquals(true, checkBool);
	}

	@Test
	public void scheduleBackupFalse() {
		boolean checkBool = ScheduleBackup.createTimeBackup(year, month, day, hour, minute, dateEnd);
		assertNotEquals(false, checkBool);
	}
}
