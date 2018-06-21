package org.hibernate.tutorial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private static String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
	private static String user = "root";
	private static String pwd = "123456.";
	private static Connection conn;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, pwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			shutdown();
		}
		return conn;
	}

	public static void shutdown() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
