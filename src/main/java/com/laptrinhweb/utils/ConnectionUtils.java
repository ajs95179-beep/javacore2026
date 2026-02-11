package com.laptrinhweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static String DB_URL = "jdbc:mysql://localhost:3306/javacore?serverTimezone=Asia/Tokyo";
	private static String USER = "root";
	private static String PASS = "1256";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (SQLException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
