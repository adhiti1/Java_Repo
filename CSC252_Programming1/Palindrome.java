package edu.middlesex;

public class Palindrome {

	private int palindromeInt; //store integer input by user
	
	public Palindrome(int inputNum) //constructor with integer passed as parameter
	{
		this.palindromeInt = inputNum;
	}
	
/* 
 * isPalindrome checks if integer is a palindrome and returns true if it is and false if it is not.
 * function stores the integer in reverse by 
 * 	1. convert integer to string
 *  2. Starting from end and going back;function appends each character. 
 *  	For example if number is 123 then the reverse string is 321
 *  3. Compare the reversed integer to input and see if it matches. If it matches then it is palindrome
 *  	
 */
	public boolean isPalindrome()
	{
		String palindromeString = Integer.toString(this.palindromeInt);
		String reverseString="";
		char letter;
		
		for (int i=palindromeString.length()-1; i>=0; i--) //start from end of string to begining
		{
			letter = palindromeString.charAt(i);
			//System.out.println(letter);
			reverseString = reverseString+letter; //append one character at a time
		}
		//System.out.println(reverseString);
		
		if (Integer.parseInt(reverseString) == this.palindromeInt)
				return true;
		else 
			return false;
		
	}
	
}
