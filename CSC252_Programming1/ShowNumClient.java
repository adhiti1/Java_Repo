package edu.middlesex;

/*
Program: 		ShowNumClient.java
Written by:		Adhiti Venkatesh
Description:	Client class that calls ShowNum class that 					displays asterix based on input of rows and 					columns
Challenges:		Working on ShowNum constructors, error checking 				and display
Time Spent:		15 hours

                Revision History
Date:                   By:               Action:
---------------------------------------------------
02/16/2024				AV					Created
02/17/2024				AV					Using default constructor and constructor with parameters
02/18/2024				AV					Error Checking (number between 1 and 30)
02/19/2024				AV					Error Checking
02/20/2024				AV					Debugging and documentation

*/


import java.util.Scanner;

public class ShowNumClient {

	public static void main(String[] args) {
		
		int num1;
		int num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two numbers separated by a space.  Enter -1 to exit.");

//Assignment states that default constructor and constructor with 2 numbers needs to be called.
//Constructor with 2 numbers are called first and default constructor is used in the loop.
//Program could be simplified by just calling default constructor outside loop and all logic within loop.
		
	do { //loop until numbers are between 1 and 30
			while (!sc.hasNextInt()) { //input is not valid number
				System.out.println("Enter valid number.");
				sc.next();
			}
			num1 = sc.nextInt();
			
			//System.out.println(num1);
			//check if number is out of range and not a sentinel.			
			if ((num1 < 1 || num1 > 30)&& num1 !=-1) {
				System.out.println("Enter a number between 1 and 30. To exit enter -1.");
			}

			while (!sc.hasNextInt()) { //input is not valid number.
				System.out.println("Enter valid number.");
				sc.next();
			}
	
			num2 = sc.nextInt();	
	
			//check if number is out of range and not a sentinel.			
			if ((num2 <=0 && num2 !=-1)|| (num2 > 30)) {
				System.out.println("Enter a number between 1 and 30. To exit enter -1.");
			}
			//System.out.println(num1);
			//System.out.println(num2);
	} while (((num1 < 1 || num1 > 30) && (num1 != -1)) || ((num2 < 1 || num2 > 30) && (num2 != -1)));
		
		ShowNum shownum1 = new ShowNum(num1, num2); //constructor with 2 numbers
		shownum1.display(); //display asterix
		
		//Using default constructor
		ShowNum shownum2 = new ShowNum();		
		
		while (num1 != -1 || num2 != -1) {

			System.out.println("Enter two numbers separated by a space.  Enter -1 to exit.");
			do {
				//Check if it is a valid number
				while (!sc.hasNextInt()) {
					System.out.println("Enter valid number.");
					sc.next();
				}
				num1 = sc.nextInt();
				
				//check if number is out of range and not a sentinel.			
				if ((num1 <=0 && num1 !=-1)|| (num1 >30)) {
					System.out.println("Enter a number between 1 and 30. To exit enter -1.");
				}
	
				if (num1 == -1)
					break; //exit loop
				
				while (!sc.hasNextInt()) {
					System.out.println("Enter valid number.");
					sc.next();
				}
				num2 = sc.nextInt();
	
				//check if number is out of range and not a sentinel.
				if ((num2 <=0 && num2 !=-1)|| (num2 >30)) {
					System.out.println("Enter a number between 1 and 30. To exit enter -1.");
				}
	
				if (num2 == -1)
					break; //exit inner loop
			} while (((num1 < 1 || num1 > 30) && (num1 != -1)) || ((num2 < 1 || num2 > 30) && (num2 != -1)));
				
			if (num1 == -1 || num2 == -1) break; //exit outer loop
			shownum2.setRow(num1); //set value of row 
			shownum2.setCol(num2); //set value of col
			shownum2.display(); //display

			} ;
			sc.close(); //close scanner object	
	}
}
