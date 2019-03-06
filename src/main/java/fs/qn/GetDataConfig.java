package fs.qn;

import java.util.ResourceBundle;

public class GetDataConfig {

	private static ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	public static final String dbDriver = getBundleValue(bundle, "dbDriver");
	public static final String dbUrl = getBundleValue(bundle, "dbUrl");
	public static final String dbUser = getBundleValue(bundle, "dbUser");
	public static final String dbPass = getBundleValue(bundle, "dbPass");
	public static final String dbName = getBundleValue(bundle, "dbName");
	public static final String sqlPath = getBundleValue(bundle, "sqlPath");
	public static final String savePath = getBundleValue(bundle, "savePath");
	public static final String tbName = getBundleValue(bundle, "tbName");
	
	public static final String dbNameSV = getBundleValue(bundle, "dbNameSV");
	public static final String PathSV = getBundleValue(bundle, "PathSV");
	public static final String dbMyServer = getBundleValue(bundle, "dbMyServer");

	/**
	 * Get value of key in resource file.
	 * 
	 * @param bundle
	 * @param key
	 * @return Value of key in resource file.
	 */
	public static String getBundleValue(ResourceBundle bundle, String key) {
		String value = bundle.getString(key);
		return value;
	}

}
