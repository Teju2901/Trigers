package com.softtek.ja.hms3.helper;

import java.util.Scanner;

import com.softtek.java.hms3.domain.Table;



public class TableValidation {
	public static void tableAvailability(String val) {
		if(val.equals("no"))
	{
			System.out.println("Please Choose another Table");
			Table.tableBook();
	}
		
		
		else {
			System.out.println("\nyour table is booked!");
			System.out.println("please have a seat!");
		}
	}
	
	public static String tableValid() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\nPlease select table which are avaliable ");
		String ans=sc.next();
		String regex="[0-9]";
		if(ans.matches(regex)) 
		{
			return ans;
		}
		
		System.out.println("Please enter valid table number");
		return tableValid();
		
	}

}
