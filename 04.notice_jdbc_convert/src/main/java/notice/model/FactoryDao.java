package notice.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FactoryDao {
	// singleton pattern
	private static FactoryDao instance;
	
	// beans-map.xml : constructor 인젝션 자동 주입 설정 (map)
	private static Map dbserver;
	private static List dbserver2;
	private static Properties dbserver3;
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	/** default constructor */
	/*private FactoryDao() {
//		System.out.println("factoryDao default constructor");
	}
	
	public static FactoryDao getInstance() {
		if(instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}*/

	/** Map parameter 초기화 생성자 */
	private FactoryDao(Map dbserver){
//		System.out.println("factoryDao constructor");
		
		driver = dbserver.get("driver").toString();
		url = dbserver.get("url").toString();
		username = dbserver.get("username").toString();
		password = dbserver.get("password").toString();
		this.dbserver = dbserver;
	}
	
	public static FactoryDao getInstance(Map dbserver) {
		if(instance == null) {
			instance = new FactoryDao(dbserver);
		}
		return instance;
	}
	
	private FactoryDao(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static FactoryDao getInstance(String driver, String url, String username, String password) {
		if(instance == null) {
			instance= new FactoryDao(driver, url, username, password);
		}
		return instance;
	}
	
	private FactoryDao(List dbserver2){
//		System.out.println("factoryDao constructor");
		
		driver = dbserver2.get(0).toString();
		url = dbserver2.get(1).toString();
		username = dbserver2.get(2).toString();
		password = dbserver2.get(3).toString();
		this.dbserver2 = dbserver2;
	}
	
	public static FactoryDao getInstance(List dbserver2) {
		if(instance == null) {
			instance = new FactoryDao(dbserver2);
		}
		return instance;
	}
	
	private FactoryDao(Properties dbserver3) {
		driver = dbserver3.getProperty(driver);
		url = dbserver3.getProperty(url);
		username = dbserver3.getProperty(username);
		password = dbserver3.getProperty(password);
		this.dbserver3 = dbserver3;
	}
	
	public static FactoryDao getInstance(Properties dbserver3) {
		if(instance == null) {
			instance = new FactoryDao(dbserver3);
		}
		return instance;
	}
	
	/** DBMS 연결 객체 반환 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	/** DBMS 자원해제 */
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if(rs != null){	rs.close(); }
		if(pstmt != null){ pstmt.close(); }
		if(con != null){ con.close(); }
	}
	
	/** DBMS 자원해제 */
	public void close(Statement stmt, PreparedStatement pstmt, Connection con) throws SQLException {
		if(stmt != null){ stmt.close(); }
		if(pstmt != null){ pstmt.close(); }
		if(con != null){ con.close(); }
	}
}
