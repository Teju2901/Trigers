package com.softtek.java.hms3.domain;

import java.util.Scanner;

import com.softtek.ja.hms3.helper.DeleteBillData;



public class Payment {
	static Scanner sc = new Scanner(System.in);

	public static void pay(double tot) {
		System.out.println("Select your payment mode...");
        System.out.println("1.Card ");
        System.out.println("2.Cash ");
        int mode = sc.nextInt();
        boolean check = true;
        while(check) {
            switch(mode) {
            case 1:
                System.out.println("Please Swipe Your Card");
                System.out.println("Your bill paid successfully...");
                System.out.println("Thank you visit again...");
                System.out.println();
                System.out.println();
                DeleteBillData.operation();
                check = false;
                break;
            
            case 2:
                System.out.println("Pay your bill amount..");
                double amnt = sc.nextDouble();
                
                if(amnt==tot) {
                    System.out.println("your bill paid successfully..");
                    System.out.println("Thank you visit again...");
                    System.out.println();
                    System.out.println();
                    DeleteBillData.operation();
                    
                }
                else {
                    System.out.println("Please re-enter valid amount..");
                    Bill.totalBill();
                }
                check = false;
                break;
            default:
                System.out.println("Invalid choice");
                System.out.println("Please Choose correct mode of payment");
                
        }
		}
	}

}
