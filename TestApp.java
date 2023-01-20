package com.app.controller;

import java.util.Scanner;

import com.app.dto.Student;
import com.app.service.IStudentService;
import com.app.serviceFactory.StudentServiceFactory;

public class TestApp {
	
	static IStudentService studentService = StudentServiceFactory.getStudentService();
	static Scanner sc = new Scanner(System.in);
	
	private static void insertionOpertaion() {
		
		
		System.out.print("Enter Student name :: ");
		String sname = sc.next();
		
		System.out.print("Enter Student Age :: ");
		int sage = sc.nextInt();
		
		System.out.print("Enter Student City :: ");
		String city = sc.next();
		
		String result = studentService.insertStudentData(sname, sage, city);
		
		if (result.equalsIgnoreCase("success")) {
			System.out.println("Student Insertion successfull");
		}else {
			System.out.println("Student Insertion failed");
		}
		
		System.out.println("");
		
	}
	

	private static void selectOperation() {
		
		int sid = 0;
		System.out.print("Enter Student Id :: ");
		sid = sc.nextInt();
		
		Student std = studentService.selectStudentsData(sid);
		if (std != null) {
			System.out.println(std);
		} else {
			System.out.println("Record not Found.");
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Choose :: 1. Insertion Operation , 2. Select Operation , 3.Update Operation , 4.Delete Oeration");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			insertionOpertaion();
			break;
		case 2:
			selectOperation();
			break;
		default:
			break;
		}
		
	}


}
