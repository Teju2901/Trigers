package com.softtek.java.hms3.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.softtek.ja.hms3.helper.IdGenerator;

public class Bill {
	private static final DecimalFormat dfZero = new DecimalFormat("0.00");

	static Scanner sc = new Scanner(System.in);
//		public static void main(String[] args) { 

	public static void billMethod() {
		String URL = "jdbc:mysql://localhost:3306/hms";
		String User = "root";
		String Password = "Softtek@2022";
		Connection conn;
		Statement stat;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : ");
			System.out.println(e.getMessage());
		}

		try {
			conn = DriverManager.getConnection(URL, User, Password);
			stat = conn.createStatement();

			ResultSet rs1 = stat.executeQuery("select * from order1");

			System.out.println("your order is....");
			System.err.println("itemId -- item -- quantity -- price");
			while (rs1.next()) {
				String v3 = rs1.getString(1);
				String v2 = rs1.getString(2);
				String v4 = rs1.getString(3);
				String v5 = rs1.getString(4);

				System.out.println("   " + v3 + "       " + v4 + "       " + v5 + "      " + v2);
			}

			stat.close();
			conn.close();

			totalBill();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	}

	public static void totalBill() {
		String URL = "jdbc:mysql://localhost:3306/hms";
		String User = "root";
		String Password = "Softtek@2022";
		Connection conn;
		Statement stat;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : ");
			System.out.println(e.getMessage());
		}

		try {
			conn = DriverManager.getConnection(URL, User, Password);
			stat = conn.createStatement();

			ResultSet rs1 = stat.executeQuery("select sum(price) from order1");
			rs1.next();

			double tot = rs1.getDouble("sum(price)");

			ResultSet rs2 = stat.executeQuery("select sum(price)*0.09 from order1");
			rs2.next();
			double tot1 = rs2.getDouble("sum(price)*0.09");

			ResultSet rs4 = stat.executeQuery("select sum(price)*0.09 from order1");
			rs4.next();
			double tot3 = rs4.getDouble("sum(price)*0.09");
			
			

			int tot5 = Customer.getCustomerId();
			double tot2 = tot + tot1 + tot3;
			int tot4 = IdGenerator.getId();

			stat.executeUpdate("insert into bill(customerid,orderId,totalBill,date_Time) values(" + tot5 + "," + tot4 + "," + tot2 +", now() )");
            System.out.println("==========================================================");
			System.out.println("sumprice is  : " + dfZero.format(tot));
			 System.out.println("==========================================================");
			System.out.println("sgst is : " + dfZero.format(tot1));
			 System.out.println("==========================================================");
			System.out.println("cgst is : " + dfZero.format(tot3));
			 System.out.println("==========================================================");
			System.out.println("Total bill is :" +  dfZero.format(tot2));

			Payment.pay(tot2);

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	}

}
