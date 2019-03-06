package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class BackupDatabaseTest {
	private static BackupDatabase backupDatabase;
	String dbNameMS = "jsp";
	String dbNameSV = "EMS";
	String savePath = "D:\\sql";
	String serverName = "AUTO_TRY\\SQLEXPRESS";

	@BeforeClass
	public static void prepareForAllTest() {
		backupDatabase = new BackupDatabase();
	}

	@Test
	public void backupMySqlEqualTest() {
		boolean check = backupDatabase.backupDBMySql(dbNameMS, savePath);
		assertEquals(check, true);
	}

	@Test
	public void backupMySqlNotEqualsTest() {
		boolean check = backupDatabase.backupDBMySql(dbNameMS, savePath);
		assertNotEquals(check, false);
	}
	
	@Test
	public void backupSqlServerEqualsTest() {
		boolean check = backupDatabase.backupDBSqlServer(serverName, dbNameSV, savePath);
		assertNotEquals(check, false);
	}
	
	@Test
	public void backupSqlServerNotEqualsTest() {
		boolean check = backupDatabase.backupDBSqlServer(serverName, dbNameSV, savePath);
		assertNotEquals(check, false);
	}
}
