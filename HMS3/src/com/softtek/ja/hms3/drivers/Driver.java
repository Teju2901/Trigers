package com.softtek.ja.hms3.drivers;

import java.util.Scanner;

import com.softtek.ja.hms3.helper.DeleteBillData;
import com.softtek.ja.hms3.helper.FeedBack;
import com.softtek.java.hms3.domain.Bill;
import com.softtek.java.hms3.domain.Customer;
import com.softtek.java.hms3.domain.Employee;
import com.softtek.java.hms3.domain.Hotel;
import com.softtek.java.hms3.domain.Menu;
import com.softtek.java.hms3.domain.Order;
import com.softtek.java.hms3.domain.Table;

public class Driver {
	static Scanner sc = new Scanner(System.in);
	Hotel a = new Hotel();

	public static void FirstEntry() {

		while (true) {
			System.out.println("Enter Your choice");
			System.out.println("1. ADMIN");
			System.out.println("2. CUSTOMER");
			System.out.println("3. CLOSE HOTEL");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Login to Admin portal");
				FeedBack.adminLogin();
				Employee a = new Employee();
				a.adminWork();
				break;
			case 2:
				Customer b = new Customer();
				b.customerDetails();
				Table table = new Table();
				table.tableDetails();
				Menu d = new Menu();
				d.menuList();
				Order f = new Order();
				f.orderList();
				Bill e = new Bill();
				e.billMethod();

				FeedBack h = new FeedBack();
				h.feedback();
//			h.finance();
//			h.revenue();

				break;
			case 3:
				DeleteBillData.setTable();
				System.exit(0);
				break;
			default:
				System.out.println(" invalid choice");

			}
		}
	}

}
