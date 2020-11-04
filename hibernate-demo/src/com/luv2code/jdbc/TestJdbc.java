package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("connecting to database:" + jdbcUrl);
			Connection mConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("sucessful");
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
