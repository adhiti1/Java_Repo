package edu.middlesex;

//Customer Class 

//import java.util.ArrayList;
//import java.util.List;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Customer {

	private int CustomerID; //unique customer number using a random number
	private String Name;
	private String Address;
	private String City;
	private String State;
	private String Zip;
	private CheckingAccount myChecking; //uses composition - CheckingAccount Class
	private SavingsAccount mySavings; //uses composition - SavingsAccount class
	
	
	public Customer (int ID)
	{
		this.CustomerID = ID;
	}
	
	
	public Customer(int ID, String Name, String Addr, String City, String State, String Zip)
	{
		this.CustomerID = ID;
		this.Name = Name;
		this.Address = Addr;
		this.City = City;
		this.State = State;
		this.Zip = Zip;
	}
	
	//method updates customer attributes
	public void setupCustomer (String Name, String Addr, String City, String State, String Zip)
	{
		this.Name = Name;
		this.Address = Addr;
		this.City = City;
		this.State = State;
		this.Zip = Zip;		
	}
	
	//method uses overloading to add account. parameter is checking account
	public void AddAccount(CheckingAccount chk)
	{
		this.myChecking = chk;
	}
	
	//method uses overloading to add account. parameter for this method is savings account.
	public void AddAccount(SavingsAccount sav)
	{
		this.mySavings = sav;
	}
	
	//method uses overloading to deposit amount to checking account.
	public void Deposit(CheckingAccount chk , double amount)
	{
		this.myChecking.Deposit(amount);
	}
	
	//method uses overloading to deposit amount to savings account.
	public void Deposit(SavingsAccount sav, double amount)
	{
		this.mySavings.Deposit(amount);
	}
	
	//method uses overloading to withdraw amount from checking account.
	public void Withdraw(CheckingAccount chk, double amount)
	{
		this.myChecking.withdraw(amount);
	}
	
	//method uses overloading to withdraw amount from savings account.
	public void Withdraw(SavingsAccount sav, double amount)
	{
		this.mySavings.withdraw(amount);
	}
	
	//print transactions
	public String PrintTransactions()
	{
		String rtn;
		String temp_Msg;
		
		rtn =this.Name + '\n'+ this.Address+'\n' +this.City+" "+this.State+" "+ this.Zip;

		if (this.myChecking != null) //if checking account is not setup then don't print anything
		{
			temp_Msg=this.myChecking.printTransactions();
			rtn = rtn+ '\n'+temp_Msg;
		}
		if (this.mySavings != null) //if savings account is not setup then don't print
		{
			temp_Msg = this.mySavings.printTransactions();
			rtn = rtn + '\n'+temp_Msg;
		}
		
		return rtn;
	}
	
	//customer id using random number
    static int getNextID()
    {
    	return ThreadLocalRandom.current().nextInt(99999999);
    }
}
