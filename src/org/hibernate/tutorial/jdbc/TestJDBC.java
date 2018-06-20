package org.hibernate.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "root";
		String pwd = "123456.";
		
		System.out.println("Connecting to db: " + url);
		
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		System.out.println("Connection Succesfull");
		
		conn.close();
	}
}
