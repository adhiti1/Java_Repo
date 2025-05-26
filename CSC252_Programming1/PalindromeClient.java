package edu.middlesex;


/*
Program: 		PalindromeClient.java 
Written by:		Adhiti Venkatesh
Description:	Calls Palindrome class and tests if number is palindrome
Challenges:		coming up with logic for isPalindrome method
Time Spent:		15 hours

                Revision History
Date:                   By:               Action:
---------------------------------------------------
02/28/2024				AV					Created
02/29/2024				AV					Using default constructor
02/30/2024				AV					Palindrome Class and isPalindrome method
03/2/2024				AV					isPalindrome method, error checking code
03/3/2024				AV					Debugging and documentation
03/4/2024				AV					documentation

*/


import java.util.Scanner;

public class PalindromeClient {

	public static void main(String[] args) {
	
		
		int num1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter an integer to see if it is a palindrome.  Enter -1 to exit.");
		do { //loop until you get -1 which is sentinel.
			while (!sc.hasNextInt()) { //input is not valid integer
				System.out.println("Enter valid integer.");
				sc.next();
			}
			num1 = sc.nextInt();
			
			//System.out.println(num1);
			//check if number is not a sentinel.			
			if  (num1 == -1) {
				break;
			}
			
			Palindrome palindrome1 = new Palindrome(num1); //constructor with 1 number
			
			//System.out.println(palindrome1.isPalindrome());
			
			if (palindrome1.isPalindrome() == true) //call method to check if it is palindrome.
				System.out.println(Integer.toString(num1)+ " is a palindrome.");
			else
				System.out.println(Integer.toString(num1)+ " is not a palindrome.");
			
	} while (num1 != -1); //until user enters a sentinel of -1

	}
}
