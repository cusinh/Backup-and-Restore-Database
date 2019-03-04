package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class RestoreTest {
	
	String tbName = "skill";

	@Test
	public void restoreDBTestTrue() {
		boolean check = RestoreDatabase.restoreDbFromSQL();
		assertEquals(true, check );
	}
	
	@Test
	public void restoreTableTestTrue() {
		assertEquals(true, RestoreTable.restoreTableFromSQL(tbName));
	}
	
	@Test
	public void restoreDBTestFalse() {
		boolean check = RestoreDatabase.restoreDbFromSQL();
		assertNotEquals(false, check );
	}
	
	@Test
	public void restoreTableTestFalse() {
		assertNotEquals(false, RestoreTable.restoreTableFromSQL(tbName));
	}

}
