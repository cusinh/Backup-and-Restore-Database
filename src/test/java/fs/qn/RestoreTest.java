package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class RestoreTest {

	String tbName = "skill";
	String dbName = "sk";
//- test Restore MySQL
	@Test
	public void restoreDBTestTrue() {
		boolean check = RestoreDatabase.restoreDBMySQL(dbName);
		assertEquals(true, check);
	}

	@Test
	public void restoreDBTestFalse() {
		boolean check = RestoreDatabase.restoreDBMySQL(dbName);
		assertNotEquals(false, check);
	}

	@Test
	public void restoreTableTestTrue() throws IOException, InterruptedException, SQLException {
		boolean check1 = RestoreTable.Restore(tbName);
		assertEquals(true, check1);
	}

	@Test
	public void restoreTableTestFalse() throws IOException, InterruptedException, SQLException {
		boolean check1 = RestoreTable.Restore(tbName);
		assertNotEquals(false, check1);
	}
	//- Test Restore SQL Server
	@Test
	public void restoreDBSQLServerTrue() {
		boolean check2 = RestoreDatabase.restoreDBSQLServer();
		assertEquals(true, check2);
	}
	@Test
	public void restoreDBSQLServerFalse() {
		boolean check2 = RestoreDatabase.restoreDBSQLServer();
		assertNotEquals(false, check2);
	}
}
