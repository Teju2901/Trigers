package com.softtek.ja.hms3.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.softtek.java.hms3.domain.Table;



public class DeleteBillData {
	public static void operation(){
		String URL = "jdbc:mysql://localhost:3306/hms";
		String User = "root";
		String Password = "Softtek@2022";
		Connection conn;
		Statement stat;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException : ");
			System.err.println(e.getMessage());

		}
		try {
			 conn = DriverManager.getConnection(URL, User, Password);
	            stat = conn.createStatement();
	             String query="TRUNCATE TABLE order1  ";
	                   stat.executeUpdate(query);
	                   
	            int tnum =   Table.getTableNum();
	            stat.executeUpdate("update tablebooking set availability= 'yes' where tablenumber = "+ tnum );
	                 
	                
	            stat.close();
	            conn.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		}
	public static void setTable() {
		String URL = "jdbc:mysql://localhost:3306/hms";
		String User = "root";
		String Password = "Softtek@2022";
		Connection conn;
		Statement stat;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException : ");
			System.err.println(e.getMessage());

		}
		try {
			 conn = DriverManager.getConnection(URL, User, Password);
	            stat = conn.createStatement();
	            stat.executeUpdate("update tablebooking set availability= 'yes' where availability='no'" );
                
                
	            stat.close();
	            conn.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
	}

}
