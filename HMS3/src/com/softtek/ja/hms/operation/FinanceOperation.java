package com.softtek.ja.hms.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.java.hms3.domain.Admin;

public class FinanceOperation implements Admin {

	private int SINo;
	private String expenses;
	private String amount;
	static Scanner sc = new Scanner(System.in);

	public static void financeOp() {
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
		FinanceOperation b = new FinanceOperation ();
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

			System.out.println("inserting into finance table");

			System.out.println("Enter SINo :");
			int Sino = sc.nextInt();

			System.out.println("Enter expenseName :");
			String expName = sc.next();
			String namepattern = "[a-zA-Z]+\\.?";
			if (!expName.matches(namepattern)) {
				System.out.println("Your expensename is not valid ");
				System.out.println("Please enter a valid name: ");
				System.out.println();
				System.out.println("Enter expenseName :");
				expName = sc.next();
			}

			System.out.println("Enter amount :");
			double amt = sc.nextDouble();

			String employeequery = "Insert into finance values( " + Sino + ", '" + expName + "', " + amt + " )";
			stat.executeUpdate(employeequery);
			System.out.println("inserted financeExpense successfully");
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

			System.out.println("Updating financeTable");

			System.out.println("Enter SINo");
			int SIno = sc.nextInt();

			System.out.println("enter data which is to be updated");
			System.out.println("1.Update ExpenseName");
			System.out.println("2.Update Amount");
			int op = sc.nextInt();
			if (op == 1) {
				System.out.println("Enter ExpenseName ");
				String name = sc.next();

				String updatefi = "update finance set expenses= '" + name + "'  where SINo = " + SIno + "";
				stat.executeUpdate(updatefi);
			} else if (op == 2) {
				System.out.println("Enter Amount");
				double amt = sc.nextDouble();

				String updatefi = "update finance set amount= '" + amt + "'  where  SINo= " + SIno + "";
				stat.executeUpdate(updatefi);
			} else {
				System.out.println("Invalid option");
			}

			System.out.println("Finance table updated Successfully");

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

			System.out.println("Deleting FinanceTableRow");

			System.out.println("Enter SINo");
			int id = sc.nextInt();

			stat.executeUpdate("delete from finance where SINo= " + id + "");

			stat.close();
			conn.close();

			System.out.println("FinanceRow Deleted Successfully");

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

}
