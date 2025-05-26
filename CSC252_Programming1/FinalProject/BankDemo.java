package edu.middlesex;

/*
Program: 		BankDemo.java
Written by:		Adhiti Venkatesh
Description:	This project shows object oriented design and programming of a simple banking application using inheritance and composition.
Challenges:		Main challenge was designing and coding classes around inheritance,composition, error checking and user interface.
Time Spent:		about 80 hours

                Revision History
Date:                   By:               Action:
---------------------------------------------------
04/04-04/10/24			AV					Design Document
04/13-04/20				AV					Created Class, Client Class, shell for debugging
04/21-04/24				AV					User Interface using scanner
04/24-04/27				AV					Testing and documentation

Design document - Separate design document that has UML for classes, UI screens and implementation logic.
Mapping requirements document - separate document is attached that maps the requirement to how it was programmed. 
Predicted Test results - separate document contains normal scenarios and exception scenarios.
*/


import java.text.NumberFormat;
import java.util.*;

public class BankDemo {

	//Method to display menu
	public static void menuoptions() {
		
		System.out.println("Banking Main Screen\n");
		System.out.println("1. Add Customer");
		System.out.println("2. Add Checking or Savings Account");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Print Customer Transaction");
		System.out.println("6. Quit");
	}

	
	public static void main(String[] args) {

		int choice;
		int customerID = Customer.getNextID(); //Customer Number
		int checkingAcctID = CheckingAccount.getNextID(); //Checking Account Number
		int savingsAcctID = SavingsAccount.getNextID(); //Savings Account Number
		boolean CustSetup = false;  //variable to indicate if customer has been setup
		boolean SavAcctSetup = false; //variable to indicate if savings account has been setup
		boolean ChkAcctSetup = false; //variable to indicate if checking has been setup
		String Message;
		
		//create instances of checking, savings and customer
		CheckingAccount myChecking = new CheckingAccount(checkingAcctID); 
		SavingsAccount mySaving = new SavingsAccount(savingsAcctID);
		Customer myCust = new Customer(customerID);
		
		//create scanner instance
        Scanner input = new Scanner(System.in);
		menuoptions(); //display menu
		
		while (true) { //loop until user exits.
			
			System.out.println("\nEnter Your Menu Choice: ");
			try {
	                choice = input.nextInt(); //get user choice
	                
	                switch (choice) {
	                case 1: //Add customer menu option
	                {
	                	//check if customer has been setup
	                	if (CustSetup == true) { // initially it is false and will be set to true once customer is setup.
	                		System.out.println("Customer has already been added. Please select a different menu option.");
	                		break;
	                	}
	                	input.nextLine();	//used to remove \n from console buffer. so it does not skip any items.
	                	System.out.print("Enter the following Customer Information:\n");
	                	//get customer name
	                	String name;
            			System.out.print("Name:");
	            		name = input.nextLine();                	
	                	
	                	String Addr;
            			System.out.print("Address:");
	            		Addr = input.nextLine();                	

	                	String City;
            			System.out.print("City:");
            			City = input.nextLine();                	

	                	String State;
            			System.out.print("State:");
            			State = input.nextLine();                	

	                	String Zip;
            			System.out.print("Zip:");
            			Zip = input.nextLine();                	

	                	CustSetup = true;
	                	
	                	myCust.setupCustomer(name, Addr, City, State, Zip); //update instance with attributes
						System.out.println(customerID + " has been created.");
						 break;
	                }
	                		                	
	                case 2: //checking and savings account menu option
	                	if (CustSetup == false) //user incorrectly selects menu before setting up customer.
	                	{
	                		System.out.println("Customer has not been setup. Please Setup customer first.");
	                		break;
	                	}
	                	input.nextLine();	//used to remove \n from console buffer.
	                	
	                	if (SavAcctSetup == true && ChkAcctSetup == true ) 
	                	{ //both have been setup
	                		System.out.println("Both Savings and Checking Accounts have been setup. Please select a different menu option.");
	                		break;
	                	}
	                	
	                	String AcctType;
	                	if (SavAcctSetup == true) //if savings account has been setup then open up checking.
	                	{ //can only setup checking account
                			System.out.print("Savings Account has been setup.  Setting up Checking Account.\n");
	                		double balance;
	                		System.out.print("Initial Deposit:");
	                		balance = input.nextDouble();
	                		double IntRate;
	                		System.out.print("Interest Rate:");
	                		IntRate = input.nextDouble();
	                		double MinBalance;
	                		System.out.print("Minimum Balance");
	                		MinBalance = input.nextDouble();
	                		double overdraft;
	                		System.out.print("Overdraft Amount");
	                		overdraft = input.nextDouble();
	                		myChecking.MinimumBalance = MinBalance; //static variable and hence can be asssigned.
	                		myChecking.setupAccount(balance, IntRate, overdraft);
	                		myCust.AddAccount(myChecking); //add checking account to customer.
	                		ChkAcctSetup = true; //set variable to true so we don't set it up again.
	                		break;
	                	}
	                	if (ChkAcctSetup == true) //checking account has been setup. Open savings
	                	{ //can now setup Savings account
                			System.out.print("Checking Account has been setup.  Setting up Savings Account.\n");
	                		double balance;
	                		System.out.print("Initial Deposit:");
	                		balance = input.nextDouble();
	                		double IntRate;
	                		System.out.print("Interest Rate:");
	                		IntRate = input.nextDouble();
	                		mySaving.setupAccount(balance, IntRate);
	                		myCust.AddAccount(mySaving); //add savings account to customer
	                		SavAcctSetup = true; //set variable to true so we don't set it up again.
	                		break;
	                	}
	                	
	                	//else let user choose between savings or checkings
            			System.out.print("Enter S for Savings or C for Checkings :");
            			while (!input.hasNext("[scSC]")) //account for upper and lower case.
            			{
            				System.out.println("Please Enter S for Savings or C for Checking.");
            				input.next();
            			}
               			AcctType = input.next();
                		if (AcctType.toLowerCase().charAt(0) == 's') //convert to lower case and then check.
                		{
	                		double balance;
	                		System.out.print("Initial Deposit:");
	                		balance = input.nextDouble();
	                		double IntRate;
	                		System.out.print("Interest Rate:");
	                		IntRate = input.nextDouble();
	                		mySaving.setupAccount(balance, IntRate);
	                		myCust.AddAccount(mySaving);  //add savings account to customer
	                		SavAcctSetup = true;
	                		break;
                		}
                		else
                		{
	                		double balance;
	                		System.out.print("Initial Deposit:");
	                		balance = input.nextDouble();
	                		double IntRate;
	                		System.out.print("Interest Rate:");
	                		IntRate = input.nextDouble();
	                		double MinBalance;
	                		System.out.print("Minimum Balance");
	                		MinBalance = input.nextDouble();
	                		double overdraft;
	                		System.out.print("Overdraft Amount");
	                		overdraft = input.nextDouble();
	                		myChecking.MinimumBalance = MinBalance; //static variable assignment
	                		myChecking.setupAccount(balance, IntRate, overdraft);
	                		myCust.AddAccount(myChecking); //add checking account to customer.
	                		ChkAcctSetup = true;
	                		break;
                		}
	                
	                case 3:  //deposit
	                	if (CustSetup == false) { //customer has not been setup.
	                		System.out.println("Customer has not been setup. Please Setup customer first.");
	                		break;
	                	}

	                	if (SavAcctSetup == false && ChkAcctSetup == false ) { //both accounts have not setup
	                		System.out.println("Both Savings and Checking Accounts have not been setup. Please select a different menu option.");
	                	break;
	                	}

	                	if (SavAcctSetup == true && ChkAcctSetup == true ) 
	                	{ //both have been setup; ask which one to deposit
	            			System.out.print("Enter S for Savings or C for Checkings :");
	            			while (!input.hasNext("[scSC]")) 
	            			{
	            				System.out.println("Please Enter S for Savings or C for Checking.");
	            				input.next();
	            			}
	               			AcctType = input.next();
	                		double depositAmt;
	                		Message = null;
	                		System.out.print("Deposit Amount:");
	                		depositAmt = input.nextDouble();
	                		if (AcctType.toLowerCase().charAt(0) == 's')
	                		{
		                		Message = mySaving.Deposit(depositAmt);
	                			System.out.println(Message);
	                		}
	                		else
	                		{
		                		Message = myChecking.Deposit(depositAmt);
		                		System.out.println(Message);
	                		}
	                	break;
	                	}
	                	
	                	if (SavAcctSetup == true) //change prompt based on account
	                		System.out.print("Enter Amount deposited into Savings:");
	                	else
	                		System.out.print("Enter Amount deposited into Checking:");
                		double depositAmt;
                		Message = null;
                		depositAmt = input.nextDouble();
	                	if (SavAcctSetup == true) //call appropriate method.
	                	{
	                		Message = mySaving.Deposit(depositAmt);
	                		System.out.println(Message);
	                	}
	                		
	                	else
	                	{
	                		Message = myChecking.Deposit(depositAmt);
	                		System.out.println(Message);
	                	}
	                	break;
	                	
	                case 4: //withdraw
	                	if (CustSetup == false) { //customer has not been setup
	                		System.out.println("Customer has not been setup. Please Setup customer first.");
	                		break;
	                	}

	                	if (SavAcctSetup == false && ChkAcctSetup == false ) { //both have not been setup
	                		System.out.println("Both Savings and Checking Accounts have not been setup. Please select a different menu option.");
	                	break;
	                	}	                	

	                	if (SavAcctSetup == true && ChkAcctSetup == true ) 
	                	{ //both have been setup; ask which one to deposit
	            			System.out.print("Enter S for Savings or C for Checkings :");
	            			while (!input.hasNext("[scSC]")) 
	            			{
	            				System.out.println("Please Enter S for Savings or C for Checking.");
	            				input.next();
	            			}
	               			AcctType = input.next();
	                		double withdrawAmt;
	                		Message =null;
	                		System.out.print("Withdraw Amount:");
	                		withdrawAmt = input.nextDouble(); //get amount to withdraw
	                		if (AcctType.toLowerCase().charAt(0) == 's') //check account type and call appropriate method
	                		{
		                		Message= mySaving.withdraw(withdrawAmt); //error message is printed in the appropriate method
		                		System.out.println(Message);
	                		}
	                		else
	                		{
	                			Message = myChecking.withdraw(withdrawAmt);
	                			System.out.println(Message);
	                		}
	                		break;
	                	}
	                	
	                	if (SavAcctSetup == true)
	                		System.out.print("Enter Amount to be withdrawn from Savings:");
	                	else
	                		System.out.print("Enter Amount to be withdrawn from Checking:");
                		double withdrawAmt;
                		Message=null;
                		withdrawAmt = input.nextDouble();
	                	if (SavAcctSetup == true)
	                	{
	                		Message= mySaving.withdraw(withdrawAmt);
	                		System.out.println(Message);
	                	}
	                	else
	                	{
	                		Message= myChecking.withdraw(withdrawAmt);
	                		System.out.println(Message);
	                	}
	                	break;
	                	
	                	
	                case 5: //print transactions
	                	if (CustSetup == true) {
	                		Message =	myCust.PrintTransactions();
	                		System.out.println(Message);
	                	}
	                	else
	                		System.out.println("Customer has not been setup. Please Setup customer first.");
	                	break;
	                case 6: //exit program
	                {
                        System.out.println("Exiting Program...");
                        System.exit(0);
	                }
	                
	                default: System.out.println("This is not a valid Menu Option! Please Select Another");
	                }
			 } catch (InputMismatchException ex){
	                System.out.println("Invalid input, please provide a number between 1 and 6");
			 }
	}
		
	}
	
}
