package com.softtek.java.hms3.domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.ja.hms3.helper.IdGenerator;



public class Customer {
	static Scanner sc = new Scanner(System.in);
	static int id;
	static  String customername;
	
	public static int getCustomerId() {
		return id;
	}
	
	public  static String  getcustomername() {
		return customername;
	}
	
	
	
	public  static void customerDetails() {
		
		System.out.println("Enter Customer Name :");
        String cName = sc.next();
        String namepattern = "[a-zA-Z]+\\.?";
        if(!cName.matches(namepattern)) {
            System.out.println("Your username is not valid ");
            System.out.println("Please enter a valid name: ");
            System.out.println();
            System.out.println("Enter Customer Name :");
            cName = sc.next();
        }
		//System.out.println("enter your id:");
		int cId = IdGenerator.getId();
		id =cId;
		String cNum = IdGenerator.phoneNo();
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
		
			
			stat.executeUpdate("insert into customer values(" +cId+ ", '" +cName +"' , '"+ cNum + "' )");
			 
			stat.close();
			conn.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}
