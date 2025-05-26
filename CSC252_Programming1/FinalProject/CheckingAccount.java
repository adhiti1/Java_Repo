package edu.middlesex;

import java.util.*;
import java.text.NumberFormat; 
import java.util.concurrent.ThreadLocalRandom;

//Checking account extends Account class.

public class CheckingAccount extends Account {


    private int AccountID;
    private double Balance;
    private ArrayList<String> transactions; //array list of string (requirement)
    private double InterestRate;
    private double OverdraftAmount;
    static double MinimumBalance; //static variable (requirement)
  
    //constructor initializes transactions variable.
    public CheckingAccount (int ID)
    {
    	this.AccountID = ID;
    	transactions = new ArrayList<String>(); //Initialize transactions array
    	transactions.add("Checking Account (Account Number:"+ID + ")");    	
    }
    
    public CheckingAccount (int ID, double Balance, double IntRate, double OverdraftAmt)
    {
    	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();    	//get default local currency format
    	this.AccountID = ID;
    	this.Balance = Balance;
    	this.InterestRate = IntRate;
    	this.OverdraftAmount = OverdraftAmt;
    	transactions = new ArrayList<String>(); //Initialize transactions array
    	transactions.add("Checking Account (Account Number:"+ID +") with initial deposit of "+ defaultFormat.format(Balance));
    }
    
    //setupAccount method updates attributes of instance.
    public void setupAccount(double Balance, double IntRate, double OverdraftAmt)
    {
    	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();    //get default local currency format
    	this.Balance = Balance;
    	this.InterestRate = IntRate;
    	this.OverdraftAmount = OverdraftAmt;
    	transactions.add("Initial deposit "+ defaultFormat.format(Balance));   //logs balance in local currency 	
    }
    
    //deposit method and logs transaction
    public String Deposit (double amount)
    {
    	String rtn =null;
    	
    	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(); //get default local currency format
    	if (amount > 0) {
    		this.Balance = this.Balance + amount;
    		transactions.add("Deposit of " + defaultFormat.format(amount)+". The current balance is " + defaultFormat.format(this.getBalance()));
    		rtn = "Deposit of " + defaultFormat.format(amount)+". The current balance is " + defaultFormat.format(this.getBalance());
    	}
		return rtn;
    }
    
    //withdraw method, logs transaction (in case of error then displays error).
    public String withdraw (double amount)
    {
    	String rtn = null;
    	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(); //get default local currency format    	
    	if (amount >0 && ( this.Balance - amount) > this.MinimumBalance ) {
    		this.Balance = this.Balance - amount;
    		transactions.add("Withdrawal of " + defaultFormat.format(amount)+". The current balance is " + defaultFormat.format(this.getBalance()));
    		rtn = defaultFormat.format(amount)+" withdrawn. "+ "The current balance is "+ defaultFormat.format(this.getBalance());
    		return rtn;
    	}
    	else
    	{
    		rtn = "Txn cancelled as "+defaultFormat.format(amount) + " will cause balance to go below "+ defaultFormat.format(this.MinimumBalance) ;
    		return rtn;
    	}
    }
    
    public double getBalance()
    {
    	return this.Balance;
    }
    
    //prints transactions
    public String printTransactions()
    {
    	String rtn = null;
    	for (int i=0; i < transactions.size(); i++) {
    		String element = transactions.get(i);
    		//System.out.println(element);
    		if (rtn !=null) 
    				rtn = rtn+"\n"+element;
    		else
    				rtn = element;
    	}
    	return rtn;
    }
    
    //Checking account number using a random number.
    static int getNextID()
    {
    	return ThreadLocalRandom.current().nextInt(999999999);
    }
}
