package org.hibernate.tutorial.test;

import java.sql.Connection;

import org.hibernate.tutorial.util.JDBCUtil;

public class TestJDBCConn {
	public static void main(String[] args) {
		Connection conn = JDBCUtil.getConnection();
		
		if(conn != null)
			System.out.println("Connection succesfull!");
		
	}
}
