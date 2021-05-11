package com.com.food.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// DB에 연결 method
public class DBContract {

	private static Connection dbConn = null;
	
	static {
		
		String jdbDriver ="oracle.jdbc.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "food";
		String password = "food";
		
			try {
				Class.forName(jdbDriver);
				
				if(dbConn == null) {
					
					dbConn = DriverManager.getConnection(url, user, password);
				}
				System.out.println("오라클 접속 ok");
				
			} catch (ClassNotFoundException e) {
				System.out.println("오라클 Driver를 찾지 못함");
				
			} catch (SQLException e) {
				System.out.println("=".repeat(30));
				System.out.println("오라클 접속 실패");
				System.out.println("접속 정보를 확인하세요");
				System.out.println("url" + url);
				System.out.println("user" + user);
				System.out.println("password" + password);
				System.out.println("=".repeat(30));
			}
	}
	
	public static Connection getDBConnection() {
		
		return dbConn;
	}
}
