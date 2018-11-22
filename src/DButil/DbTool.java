package DButil;

import java.util.ArrayList;

public class DbTool {
	
	public static String sqlInsertBuilder(String tableName, String[] columns) {
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
	
	public static ArrayList<String> paramsBuilder(Object... params) {
		ArrayList<String> pattern = new ArrayList<>();
		for (Object param : params) {
			if (param instanceof String) {
				pattern.add(param.toString());
			} else {
				pattern.add(String.valueOf(params));
			}
		}
		return pattern;
	}

}
