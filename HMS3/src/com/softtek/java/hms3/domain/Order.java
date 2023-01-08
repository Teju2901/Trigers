package com.softtek.java.hms3.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.ja.hms3.helper.IdGenerator;

public class Order {
	static Scanner sc = new Scanner(System.in);

	public static void orderList() {

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
		boolean entry = true;
		while (entry) {

			System.out.println("1.Order Food");
			System.out.println("2.Finish Order");

			int c = sc.nextInt();

			switch (c) {
			case 1: {
				try {
					conn = DriverManager.getConnection(URL, User, Password);
					stat = conn.createStatement();

					System.out.println("Enter your order(Item no)");
					int num = sc.nextInt();

					System.out.println("Enter the quantity");
					int qty = sc.nextInt();

					ResultSet rs1 = stat.executeQuery("select price from menulist where itemId = " + num + "");
					rs1.next();
					float val = qty * rs1.getFloat("price");

					ResultSet rs2 = stat.executeQuery("select itemName from menulist where itemId = " + num + "");

					rs2.next();
					String item = rs2.getString("itemName");

					stat.executeUpdate("insert into order1(itemId, price, item, quantity) values(" + num + ", " + val
							+ ", '" + item + "'  , " + qty + " )");

					System.out.println("item added!..");
					stat.close();
					conn.close();

				} catch (SQLException ex) {
					System.err.println("SQLException: " + ex.getMessage());
				}

			}
				break;

			case 2:
				entry = false;
				break;

			default:
				System.out.println(" Invalid choice");
			}

		}

	}

}
