package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String username = "hbstudent";
		String password= "hbstudent";
		try {
			System.out.println("Connecting to database: "+jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl,username, password);
			System.out.println("Connection successful");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
