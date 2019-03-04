package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class BackupDatabaseTest {
	private static BackupDatabase backupDatabase;

	@BeforeClass
	public static void prepareForAllTest() {
		backupDatabase = new BackupDatabase();
	}

	@Test
	public void backupTrueTest() {
		boolean check = backupDatabase.export();
		assertEquals(check, true);
	}

	@Test
	public void backupFalseTest() {
		boolean check = backupDatabase.export();
		assertNotEquals(check, false);
	}
}
