package com.softtek.java.hms3.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.ja.hms.operation.EmployeeOperation;
import com.softtek.ja.hms.operation.FinanceOperation;
import com.softtek.ja.hms.operation.MenuOperation;
import com.softtek.ja.hms3.helper.FeedBack;

public class Employee {
	private int empId;
	private String empName;
	private String empRole;

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpRole() {
		return empRole;
	}

	static Scanner sc = new Scanner(System.in);

	public static void adminWork() {
		while(true) {

		System.out.println("1.Display Employee Details");
		System.out.println("2.EmployeeOperation");
		System.out.println("3.MenuList");
		System.out.println("4.MenuOperation");
		System.out.println("5.FinanceOperation");
		System.out.println("6.revenue");
		System.out.println("Exit operations");

		int n1 = sc.nextInt();
		switch (n1) {
		case 1:

			Employee.empDetails();
			break;
		case 2:
			EmployeeOperation.employeeOp();
			break;
		case 3:
			Menu.menuList();
			break;
		case 4:
			MenuOperation.menuOp();
			break;
		case 5:
			FinanceOperation.financeOp();
			break;
		case 6:
			FeedBack.finance();
			FeedBack.revenue();
			break;
		case 7:
			System.exit(0);
			break;
		default:
			System.out.println(" invalid choice");
		}

		}
	}

	public static void empDetails() {
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

			ResultSet rs1 = stat.executeQuery("select * from employeedisplay");
			System.out.println("empId -- empName -- empRole--------empsalary");
			System.out.println();
			while (rs1.next()) {
				String v3 = rs1.getString(1);
				String v2 = rs1.getString(2);
				String v4 = rs1.getString(3);
				String v5=rs1.getString(4);

				System.out.println("   " + v3 + "      " + v2 + "      " + v4+"     "+v5);
			}

			stat.close();
			conn.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}

}
