package fs.qn;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class DBConfigTest {

	@Test
	public void getConnectionTestT() {
		DBConfig db = new DBConfig();
		Connection conn = db.getConnection();
		Assert.assertEquals(conn != null, true);
	}
	@Test
	public void getConnectionTestF() {
		DBConfig db = new DBConfig();
		Connection conn = db.getConnection();
		Assert.assertNotEquals(conn != null, false);
	}
}
