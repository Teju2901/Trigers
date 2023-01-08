package com.softtek.ja.hms3.helper;

import java.util.Scanner;

public class IdGenerator {
	static Scanner scan = new Scanner(System.in);

	public static int getId() {
		return ((int) (Math.random() * 1000));

	}

	public static String phoneNo() {
		System.out.print("Mobile No:-");
		String mobilNo = scan.next();
		String regex = "(0/91)?[7-9][0-9]{9}";
		while (!mobilNo.matches(regex)) {
			System.out.println("Your phone number is not valid");

			System.out.println();
			System.out.print("Mobile No:-");
			mobilNo = scan.next();

		}

		return mobilNo;
	}
	public static int rating() {
		System.out.println("Enter your rating out of 5");
		int rate = scan.nextInt();
		if(rate >0 && rate<=5) {
			return rate;	
		}
		else {
			System.out.println("Enter valid Rating");
			rating();
		}
		return rate;
	}
}
