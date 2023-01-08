package com.softtek.java.hms3.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static void menuList() {

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

			ResultSet rs1 = stat.executeQuery("select * from menulist where itemType='veg' ");
			System.out.println("itemno ----- itemtype ------------ price-------item");
			System.out.println();
			while (rs1.next()) {
				String v3 = rs1.getString(1);
				String v2 = rs1.getString(4);
				String v4 = rs1.getString(3);
				String v5 = rs1.getString(2);

				System.out.println("   " + v3 + "      " + v2 + "                    " + v4 + "      " + v5);
			};
				ResultSet rs2 = stat.executeQuery("select * from menulist where itemType='nonveg' ");
				System.out.println("itemno ----- itemtype ------------ price-------item");
				System.out.println();
				while (rs2.next()) {
				String v6 = rs2.getString(1);
			    String v7 = rs2.getString(4);
				String v8 = rs2.getString(3);
				String v9 = rs2.getString(2);

					System.out.println("   " + v6 + "      " + v7 + "                   " + v8 + "      " + v9);
				};
					
					ResultSet rs3 = stat.executeQuery("select * from menulist where itemType='dessert' ");
					System.out.println("itemno -----itemtype ------------ price-------item");
					System.out.println();
					while (rs3.next()) {
						String v10 = rs3.getString(1);
						String v11= rs3.getString(4);
						String v12= rs3.getString(3);
						String v13= rs3.getString(2);

						System.out.println("   " + v10 + "      " + v11 + "                  " + v12 + "      " + v13);

			};

			
			
			stat.close();
			conn.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
							
	}


}
