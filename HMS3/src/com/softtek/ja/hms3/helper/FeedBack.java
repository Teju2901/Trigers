package com.softtek.ja.hms3.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.softtek.ja.hms.operation.EmployeeOperation;
import com.softtek.java.hms3.domain.Customer;

public class FeedBack {
	private static final DecimalFormat dfZero = new DecimalFormat("0.00");
static	Scanner sc = new Scanner(System.in);

	public static void feedback() {
		Scanner sc = new Scanner(System.in);
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

			System.out.println("Please share your feedback");
//			ResultSet rs1 = stat.executeQuery("select customerid from customer  ORDER BY Customerid DESC  LIMIT 1");
//			rs1.next();

			int tot5 = Customer.getCustomerId();

			int rate = IdGenerator.rating();

			System.out.println("share your experience with Hotel");
			String exper = sc.nextLine();
			stat.executeUpdate("insert into feedback(customerid,rating, feedback1) values(" + tot5 + "," + rate + ",'"
					+ exper + "')");
			System.out.println("========================================================");

			System.out.println("Thank you For Your Feedback");

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}

	public static void finance() {

		Scanner sc = new Scanner(System.in);
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
			ResultSet rs1 = stat.executeQuery("select * from finance ");
			System.err.println("SINo----- Expences-------Amount");
			System.out.println();
			while (rs1.next()) {
				String v1 = rs1.getString(1);
				String v2 = rs1.getString(2);
				String v3 = rs1.getString(3);

				System.out.println(" " + v1 + "   " + v2 + "          " + v3);
			}
			;
			
//			ResultSet rs2 = stat.executeQuery("select sum(amount) from finance");
//			rs2.next();
//
//			double tot = rs2.getDouble("sum(amount)");
//			System.out.println("==========================================================");
//			System.out.println("The Total expenses of Hotel of a month is :" + tot);

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}

	public static void revenue() {
		Scanner sc = new Scanner(System.in);
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

			// PreparedStatement pspt=conn.prepareStatement("select ");

			ResultSet rs2 = stat.executeQuery("select sum(amount) from finance");
			rs2.next();

			double tot = rs2.getDouble("sum(amount)");
			System.out.println("==========================================================");
			System.out.println("The Total expenses of Hotel of a month is :" + dfZero.format(tot));
			
			ResultSet rs4 = stat.executeQuery("select * from bill ");
			System.err.println("totalBill----- date_time-------------------billId");
			System.out.println();
			while (rs4.next()) {
				String v4 = rs4.getString(3);
				String v5 = rs4.getString(4);
				String v6 = rs4.getString(5);

				System.out.println(" " + v4 + "   " + v5 + "     " + v6);
			}


			ResultSet rs10 = stat.executeQuery("select sum(totalBill) from bill");
			rs10.next();

			double bill = rs10.getDouble("sum(totalBill)");
			System.out.println("============================================================");

			System.out.println("The Bills total amount is :" + dfZero.format(bill));

			double margin = bill - tot;
			System.out.println("=============================================================");

			System.out.println(" The   NetRevenue  is :" + margin);

			if (margin > 0) {

				double t = (margin / tot) * 100;

				System.out.println("============================================================");
				System.out.println("The profit percentage  of restaurant is :" + dfZero.format(t));
			}

			else if (margin < 0) {
				double p = (margin / tot) * 100;
				System.out.println("==============================================================");
				System.out.println("The loss percentage  of restaurant is :" + dfZero.format(p));

			} else {
				System.out.println("No loss , no profit");
			}

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}

	public static void adminLogin() {
		
		String user,password;
		System.out.println("Enter your userName :");
		user=sc.nextLine();
		System.out.println("Enter your Password :");
		password=sc.nextLine();
		
		if(user.equals("STARS")&& password.equals("5stars@softtek")) {
			
			
			
			
		}
		else {
			System.out.println("Invalid userName and Password");
			 adminLogin();
			
		}
		
	}

}
