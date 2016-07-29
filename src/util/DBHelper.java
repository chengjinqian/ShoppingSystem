package util;

import java.sql.*;

public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
	private static final String username = "root";
	private static final String password = "2011210847";
	
	private static Connection conn = null;
	
	static{
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		if(conn==null){
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = DBHelper.getConnection();
			if(conn!=null){
				System.out.println("数据库连接正常");
			}else{
				System.out.println("数据库连接异常！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
