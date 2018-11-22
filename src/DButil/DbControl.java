package DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DbControl {
	private Connection conn = null;
	PreparedStatement pstmt = null;
	
	public Connection getConn() {
		return this.conn;
	}
	
	public void connect() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/igt?serverTimezone=GMT";
		String username = "root";
		String password = "password";
		try {
			Class.forName(driver);
			conn = (Connection)DriverManager.getConnection(url, username, password);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("load class failed!");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("connect sql failed!");
		}	
	}
	
	
	public boolean insert(String sql, List<String> params){
		boolean flag = false;
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			int index = 1;
			if(params != null && !params.isEmpty()){
				for(int i=0; i<params.size(); i++){
					pstmt.setObject(index++, params.get(i));
				}
			}
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("update failed");
		}
		
		flag = result > 0 ? true : false;
		return flag;
	}
	
	public void close() {
		try {
			this.conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("close connection failed");
		}
	}
	
	public String sqlInsertBuilder(String tableName, String[] columns) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ");
		sql.append(tableName);
		sql.append("(");
		int len = columns.length;
		// insert into tableName (...) values(?,?...)
		for (int i = 0; i < len; i ++) {
			sql.append(columns[i]);
			if (i != len - 1) {
				sql.append(",");
			}
		}
		
		sql.append(") values(");
		for (int i = 0; i < len; i++) {
			sql.append("?");
			if (i != len - 1) {
				sql.append(",");
			}
		}
		
		sql.append(")");
		
		System.out.println(sql);
		
		return sql.toString();
	}
	
	
	
	public Map<String, Object> findSimpleResult(String sql, List<String> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		int index  = 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(params != null && !params.isEmpty()){
				for(int i=0; i<params.size(); i++){
					pstmt.setObject(index++, params.get(i));
				}
			}
			ResultSet resultSet = pstmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int col_len = metaData.getColumnCount();
			while(resultSet.next()){
				for(int i=0; i<col_len; i++ ){
					String cols_name = metaData.getColumnName(i+1);
					Object cols_value = resultSet.getObject(cols_name);
					if(cols_value == null){
						cols_value = "";
					}				}
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return map;
	}
	
}


