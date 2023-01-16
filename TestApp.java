package com.app.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.main.StudentImpl;

public class TestApp {
	
	static Scanner sc = null;
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		int choice=0;
		int sid = 0;
		String sname = null;
		String saddress = null;
		int sage =0;
		int rowCount = 0;
		ResultSet resultSet = null;
		System.out.println("****  Welcome to Harvard University *****");
		StudentImpl studentImpl = new StudentImpl();
		choice = Menu();
		sc = new Scanner(System.in);
		try {
			do {
				switch (choice) {
				case 1:
					System.out.println("Hi!! Welcome to Student Admission Portal");
					System.out.print("Enter Student Details ==> ");
					System.out.print(" Student Name :: ");
					sname = sc.next();
					System.out.print("Student Age :: ");
					sage = sc.nextInt();
					System.out.print("Student Address :: ");
					saddress = sc.next();
					rowCount = studentImpl.insertStudentData(sname, sage, saddress);
					if(rowCount == 1) {
						System.out.println("Congratulations! Addmission Succesful");
					}else {
						System.out.println("Sorry ! Try again");
					}
					break;
				case 2:
					System.out.println("Hi!! Welcome to Student Details Portal");
					System.out.print("Enter Students Id :: ");
					sid = sc.nextInt();
					resultSet = studentImpl.selectStudentsData(sid);
					if (resultSet.next()) {
						System.out.println("*** Student Details *** ");
						System.out.println("Student Id :: "+resultSet.getInt(1));
						System.out.println("Student Name :: "+resultSet.getString(2));
						System.out.println("Student Age :: "+resultSet.getInt(3));
						System.out.println("Student Address :: "+resultSet.getString(4));
					} else {
						System.out.println("Enter valid Student Id");
					}
					break;
				case 3:
					System.out.println("*** Update Student Details ***");
					System.out.print("Enter Student Id :: ");
					sid = sc.nextInt();
					resultSet = studentImpl.selectStudentsData(sid);
					if (resultSet.next()) {
						System.out.println(" ** Students Details ** ");
						System.out.println("Student Id :: "+resultSet.getInt(1));
						System.out.println("Student Name :: "+resultSet.getString(2));
						System.out.println("Student Age :: "+resultSet.getInt(3));
						System.out.println("Student Address :: "+resultSet.getString(4));
					}
					System.out.print("Enter Student Name :: ");
					sname = sc.next();
					System.out.print("Enter Student Age :: ");
					sage = sc.nextInt();
					System.out.println("Enter Student Address :: ");
					saddress = sc.next();
					rowCount = studentImpl.updateStudentData(sid, sname, sage, saddress);
					if (rowCount == 1) {
						System.out.println("Student Details Updated Succesfully");
					}else {
						System.out.println("Sorry ! Try again");
					}
					break;
				case 4:
					System.out.println("*** Delete Student Details ****");
					System.out.print("Enter Student Id :: ");
					sid = sc.nextInt();
					rowCount = studentImpl.deletStudentData(sid);
					if (rowCount == 1) {
						System.out.println("Student Details Deleted Succesfully");
					}else {
						System.out.println("Details does'nt exist for Student Id :: "+sid);
					}
					break;	
				default:
					System.out.println("Please enter valid choice");
					break;
				}
			System.out.println();
			choice = Menu();
			}while(choice != 5);
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int Menu() {
		int choice = 0;
		sc = new Scanner(System.in);
		System.out.println("Enter ==> 1. Student Admission \n"
				+ "          2. Get Student Data \n"
				+"          3. Update Student Details \n"
				+"          4. Delete Student Details \n"
				+"          5. Exit");
		choice = sc.nextInt();
		return choice;
	}

}
