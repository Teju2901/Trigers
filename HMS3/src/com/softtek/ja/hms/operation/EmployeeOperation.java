package com.softtek.ja.hms.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.java.hms3.domain.Admin;



public class EmployeeOperation  implements Admin{
	
	private int empId;
	 private String empName;
	 private String empRole;
	static Scanner sc = new Scanner(System.in);

	public static void employeeOp() {
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
		EmployeeOperation b = new EmployeeOperation();
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

			System.out.println("Enter employeeId :");
			int empId = sc.nextInt();

			System.out.println("Enter employeeName :");
			String empName = sc.next();
			String namepattern = "[a-zA-Z]+\\.?";
			if (!empName.matches(namepattern)) {
				System.out.println("Your username is not valid ");
				System.out.println("Please enter a valid name: ");
				System.out.println();
				System.out.println("Enter employeeName :");
				empName = sc.next();
			}

			System.out.println("Enter employeeRole :");
			String empRole = sc.next();
			
			System.out.println(" Enter employee salary");
			double sal=sc.nextDouble();

			String employeequery = "Insert into employeedisplay values( " + empId + ", '" + empName + "', '" + empRole
					+ "'," + sal + " )";
			stat.executeUpdate(employeequery);
			System.out.println("inserted employee successfully");
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

			System.out.println("Updating Employeedetails");

			System.out.println("Enter EmpId");
			int id = sc.nextInt();

			System.out.println("enter data which is to be updated");
			System.out.println("1.Update Name");
			System.out.println("2.Update Role");
			System.out.println("3:Update salary");
			int op = sc.nextInt();
			if (op == 1) {
				System.out.println("Enter Employee Name");
				String name = sc.next();

				String updateemp = "update employeedisplay set empName= '" + name + "'  where empId = " + id + "";
				stat.executeUpdate(updateemp);
			} else if (op == 2) {
				System.out.println("Enter Employee Role");
				String role = sc.next();

				String updateemp = "update employeedisplay set empRole= '" + role + "'  where empId = " + id + "";
				stat.executeUpdate(updateemp);
			} else if (op == 3) {
				System.out.println("Enter Employee Salary");
				double sal = sc.nextDouble();

				String updateemp = "update employeedisplay set empsalary= '" + sal + "'  where empId = " + id + "";
				stat.executeUpdate(updateemp);
			}
			
			else {
				System.out.println("Invalid option");
			}

			System.out.println("Employee Updated Successfully");

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

			System.out.println("Deleting Employeedetails");

			System.out.println("Enter EmpId");
			int id = sc.nextInt();

			stat.executeUpdate("delete from employeedisplay where empId= " + id + "");

			stat.close();
			conn.close();

			System.out.println("Employee Deleted Successfully");

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

}
