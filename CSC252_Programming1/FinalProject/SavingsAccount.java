package edu.middlesex;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Savings Account extends Account
 */
public class SavingsAccount extends Account {
    private int AccountID;
    private double Balance;
    private ArrayList<String> transactions; //arraylist usage of requirements
    private double InterestRate;
    static double MinimumBalance; //Minimum balance for savings account. static variable.
  
    //constructor. Transactions variable is created in this method.
    public SavingsAccount (int ID)
    {
    	this.AccountID = ID;
    	transactions = new ArrayList<String>(); //Initialize transactions array
    	transactions.add("Savings Account (Account Number:"+ID +")");    	
    }
    
    
    public SavingsAccount (int ID, double Balance, double IntRate)
    {
    	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(); //get default local currency format
    	this.AccountID = ID;
    	this.Balance = Balance;
    	this.InterestRate = IntRate;
    	transactions = new ArrayList<String>(); //Initialize transactions array
    	transactions.add("Savings Account (Account Number:"+ID +") with initial deposit of "+ defaultFormat.format(Balance));
    }
    
    //update of balance and interest rate.  All updates are logged in transactions so it can be printed.
    public void setupAccount (double Balance, double IntRate)
    {
    	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(); //get default local currency format
    	this.Balance = Balance;
    	this.InterestRate = IntRate;
    	transactions.add("Initial deposit "+ defaultFormat.format(Balance));
    }
    
    //deposit method. Transactions are logged.
    public String Deposit (double amount)
    {
    	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(); //get default local currency format
    	String rtn =null;
    	
    	if (amount > 0) {
    		this.Balance = this.Balance + amount;
    		transactions.add("Deposit of " + defaultFormat.format(amount)+". The current balance is " + defaultFormat.format(this.getBalance()));
    		rtn= "Deposited " + defaultFormat.format(amount)+". The current balance is " + defaultFormat.format(this.getBalance());
    	}
    	return rtn;
    }
    
    //withdraw method. Error checking is performed in this method to ensure that user cannot withdraw if balance goes below minimum balance.
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
   // 		transactions.add("Withdrawal of $" + amount + " will cause balance to go below $"+ this.MinimumBalance );
    		rtn = "Txn cancelled as $"+defaultFormat.format(amount) + " will cause balance to go below $"+ defaultFormat.format(this.getBalance()) ;
    		return rtn;
    	}
    }
    
    public double getBalance()
    {
    	return this.Balance;
    }
    
    //print transactions is printing elements in the array.
    public String printTransactions()
    {
    	String rtn=null;
    	
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
    
    static int getNextID() //Savings account number using random number.
    {
    	return ThreadLocalRandom.current().nextInt(99999999);
    }

}
