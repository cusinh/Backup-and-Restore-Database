package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class BackupTableTest {
	@Test
	public void BackupdbtosqlTestTrue() {
		boolean check = BackupTable.Backupdbtosql("skill");
		assertEquals(true, check);
	}

	@Test
	public void BackupdbtosqlTestFalse() {
		boolean check = BackupTable.Backupdbtosql("skill");
		assertNotEquals(false,check);
	}

}
