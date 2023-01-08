package com.softtek.java.hms3.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.softtek.ja.hms3.drivers.Driver;
import com.softtek.ja.hms3.mainclass.MainClass;

public class Hotel {

	private String HotelName;
	private String Hoteladdress;
	private Long HotelContactNo;

	public String getHotelName() {
		return HotelName;
	}

	public void setHotelName(String hotelname) {
		HotelName = hotelname;
	}

	public String getHoteladdress() {
		return Hoteladdress;
	}

	public void setHoteladdress(String hoteladdress) {
		Hoteladdress = hoteladdress;
	}

	public Long getHotelContactNo() {
		return HotelContactNo;
	}

	public void setHotelContactNo(Long hotelContactNo) {
		HotelContactNo = hotelContactNo;
	}

	public String toString() {
		return "--------Welcome to :  " + getHotelName() + "\n\n------- Hoteladdress  : " + getHoteladdress()
				+ "\n\n-------HotelContactNo  :" + getHotelContactNo();

	}

	public static void hotelMangement() {
		System.out.println();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		System.out.println();

		Hotel ho = new Hotel();
		ho.setHotelName("STAR Hotel");
		ho.setHotelContactNo(9110622644l);
		ho.setHoteladdress("3rd cross, Sanjaynagar,Bangalore-560094");
		System.out.println(ho.toString());
		System.out.println();
		System.out.println("--------Serving delicious food and awarded best Hotel in area");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the time you want to visit to Hotel");
		

		int time = sc.nextInt();

		if (time >= 7 && time <= 23) {
			System.out.println("Hotel is open you can come in.....");
			Driver driver = new Driver();
			driver.FirstEntry();

		} else {
			System.out.println("Sorry,Hotel is closed you can come tomorrow... ");
			hotelMangement();

		}

	}
}
