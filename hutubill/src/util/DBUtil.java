package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String ip = "127.0.0.1";
	private static int port = 3306;
	private static String database = "hutubill";
	private static String encoding = "UTF-8";
	private static String loginName = "root";
	private static String password = "518666";
	
	// 驱动初始化放在了静态初始化块里，因为这行代码需要先执行，而且只需要执行一次就足够了。
	static {
		try {
			// 反射，获取类对象的时候，会导致类属性被初始化
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip,
				port,database,encoding);
		
		return DriverManager.getConnection(url, loginName, password);
		
	}

}
