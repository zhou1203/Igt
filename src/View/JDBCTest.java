package View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
		
		getConn();
	}
	
	public static Connection getConn() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/IGT?serverTimezone=GMT";
		String username = "root";
		String password = "zhouwh0407";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection)DriverManager.getConnection(url, username, password);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载类错误");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("连接数据库错误");
		}
		
		return conn;
		
	}

}
