package com.softtek.java.hms3.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.ja.hms3.helper.TableValidation;



public class Table {
	private static int tableNo;
    static Scanner sc = new Scanner(System.in);
    public static int getTableNum() {
        return tableNo;
    }
    
    public static void tableDetails() {



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



           ResultSet rs1 = stat.executeQuery("select * from tablebooking");
            System.err.println("Table num -- seats -- Availability");
            while (rs1.next()) {
                String v3 = rs1.getString(1);
                String v2 = rs1.getString(2);
                String v4 = rs1.getString(3);



               System.out.println( "  "+     v3 + "           " + v2 + "          " + v4);
                
            }
            
            
            stat.close();
            conn.close();
            tableBook();



       } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
        
         public static void tableBook() {
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
            
            System.out.println("Enter your table!");
            int tnum = Integer.parseInt(TableValidation.tableValid());
            
            tableNo=tnum;
            
            ResultSet rs1 = stat.executeQuery("select availability from tablebooking where tablenumber = "+ tnum);
            rs1.next();
            String ans =  rs1.getString("Availability");
            
            
            TableValidation.tableAvailability(ans);
            
            stat.executeUpdate("Update tablebooking set availability= 'no' where tablenumber = "+ tnum );
            
            stat.close();
            conn.close();



           
        }catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        
            
    }

}
