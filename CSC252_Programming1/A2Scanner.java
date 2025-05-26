package edu.middlesex;

/*
Program: 		A2Scanner.java
Written by:		Adhiti Venkatesh
Description:	Tip Calculator using Scanner
Challenges::	Working with Scanner options.
				Error checking to see if the input value is numeric
				and tip amount is one of the 3 values.
				Debugging and making sure that if there is an input error it goes back to getting
				correct value.
Time Spent:		14 hours

                Revision History
Date:                   By:               Action:
---------------------------------------------------
02/01/2024				AV					Created
02/02/2024				AV					Error Checking 
02/03/2024				AV					Error Checking
02/04/2024				AV					Debugging 

*/

import java.util.Scanner;

public class A2Scanner {
	

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		double cost;
		do {
			System.out.print("Please Enter the cost of your meal:");
//Check if it is a valid number
			while (!sc.hasNextDouble()) {
				System.out.println("Enter valid number.");
				sc.next();
			}
			cost = sc.nextDouble();
//check if cost is positive.			
			if (cost < 0) {
				System.out.println("Cost of meal should be greater than zero. Please re-enter cost.");
			}
			} while (cost <=0);
		
//Get Tip percentage		
		int tipPct;
		do {
			System.out.print("What percentage would you like to tip (15 or 18 or 20):");
//make sure tip pct is valid number
			while (!sc.hasNextInt()) {
				System.out.println("Enter valid number.");
				sc.next();
			}
			tipPct = sc.nextInt();	
//make sure tip pct is one of the 3 valid numbers.			
			if ( tipPct != 15 && tipPct !=18 && tipPct !=20 ) {
				System.out.println("Tip percent should be either 15 or 18 or 20");	
			}					
			} while (tipPct != 15 && tipPct !=18 && tipPct !=20);
		
		double tip = tipPct*cost/100;
		System.out.println("Your tip amount is: " +"$"+ String.format("%.2f", tip));
		
		double totalAmount = tip+cost;
		System.out.println("Your Bill + tip is: " + "$" + String.format("%.2f", totalAmount));
		
		int partyCount;
		do {
			System.out.print("How many people would you like to split bill with? ");
//make sure party count is valid integer.
			while (!sc.hasNextInt()) {
				System.out.println("Enter valid number.");
				sc.next();
			}
			partyCount = sc.nextInt();	
//make sure party count is positive.			
			if (partyCount <= 0) {
				System.out.println("Party count should be greater than zero. Please re-enter.");
			}
			} while (partyCount <=0);

		
		double costPerPerson = totalAmount/partyCount;
		System.out.println("Each person's share is: " + "$"+String.format("%.2f", costPerPerson));
	}

}
