package cn.ccnu.util;

import java.sql.*;
import java.sql.DriverManager;

public class DBHelper {
	private final static String DRIVER="com.mysql.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost:3306/shopping";
	private final static String USER="root";
	private final static String PWD="PFY132465";
	//获取数据库连接
	public static Connection getConnection() throws Exception{
		Class.forName(DRIVER);
		Connection conn=DriverManager.getConnection(URL,USER, PWD);
		return conn;
	}
	
	public static void closeConn(ResultSet rs,PreparedStatement ps,Connection conn) throws Exception{
		if(ps!=null)
			ps.close();
		if(conn!=null)
			conn.close();
		if(rs!=null)
			rs.close();
	}
}
