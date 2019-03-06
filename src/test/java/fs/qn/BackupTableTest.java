package fs.qn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BackupTableTest {
	@Test
	public void BackupdbtosqlTestTrue() {
		List<String> listDBTable = new ArrayList<String>();
		listDBTable.add("skill");
		listDBTable.add("employee");
		boolean check = BackupTable.backupDBtoMySql("ems", listDBTable, "C:\\Users\\Vinh\\Desktop\\TT");
		assertEquals(true, check);
	}

	@Test
	public void BackupdbtosqlTestFalse() {
		List<String> listDBTable = new ArrayList<String>();
		listDBTable.add("skill");
		listDBTable.add("employee123");
		boolean check = BackupTable.backupDBtoMySql("ems", listDBTable, "C:\\Users\\Vinh\\Desktop\\TT");
		assertNotEquals(true, check);
	}

}
