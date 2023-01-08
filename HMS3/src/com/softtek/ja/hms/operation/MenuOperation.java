package com.softtek.ja.hms.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.java.hms3.domain.Admin;

public class MenuOperation implements Admin {
	private int itemId;
	 private String itemName;
	 private String price;
	 private  String itemType;
	static Scanner sc = new Scanner(System.in);

	public static void menuOp() {
		System.out.println("1:insert");
		System.out.println("2:update");
		System.out.println("3:delete");

		System.out.println("choose option");

		int a = 0;
		try {
			a = sc.nextInt();
		} catch (Exception e) {
			System.out.println("the operation is not required");
		}
		MenuOperation b = new MenuOperation();
		switch (a) {

		case 1:
			b.add();
			break;
		case 2:
			b.update();
			break;
		case 3:
			b.delete();
		}
	}

	@Override
	public void add() {
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

			System.out.println("inserting into employee table");

			System.out.println("Enter itemId :");
			int itemId = sc.nextInt();

			System.out.println("Enter itemName :");
			String itemName = sc.next();
			String namepattern = "[a-zA-Z]+\\.?";
			if (!itemName.matches(namepattern)) {
				System.out.println("Your menuname is not valid ");
				System.out.println("Please enter a valid name: ");
				System.out.println();
				System.out.println("Enter itemName :");
				itemName = sc.next();
			}

			System.out.println("Enter price :");
			double price = sc.nextDouble();
			
			System.out.println("Enter itemType");
			String  itemtype=sc.next();

			String employeequery = "Insert into menu values( " + itemId + ", '" + itemName + "', '" + price
					+ "','" + itemtype + "' )";
			stat.executeUpdate(employeequery);
			System.out.println("inserted item successfully");
			stat.close();
			conn.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
 @Override
	public void update() {
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

			System.out.println("Updating Menuedetails");

			System.out.println("Enter itemId");
			int id = sc.nextInt();

			System.out.println("enter data which is to be updated");
			System.out.println("1.Update itemName");
			System.out.println("2.Update price");
			System.out.println("3.updating itemType");
			int op = sc.nextInt();
			if (op == 1) {
				System.out.println("Enter item Name");
				String name = sc.next();

				String updatemenu = "update menu set itemName= '" + name + "'  where itemId = " + id + "";
				stat.executeUpdate(updatemenu);
			} else if (op == 2) {
				System.out.println("Enter itemprice");
				int price = sc.nextInt();

				String updatemenu = "update menu set price= '" + price + "'  where itemId = " + id + "";
				stat.executeUpdate(updatemenu);
			} else if (op == 3) {
				System.out.println("Enter itemType");
				String type = sc.next();

				String updatemenu = "update menu set itemType= '" + type + "'  where itemId = " + id + "";
				stat.executeUpdate(updatemenu);
			}
			else {
				System.out.println("Invalid option");
			}

			System.out.println("Menu Updated Successfully");

			stat.close();
			conn.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
@Override
	public void delete() {
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

			System.out.println("Deleting itemdtails");

			System.out.println("Enter itemId");
			int id = sc.nextInt();

			stat.executeUpdate("delete from menu where itemId= " + id + "");

			stat.close();
			conn.close();

			System.out.println("item Deleted Successfully");

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	

}
