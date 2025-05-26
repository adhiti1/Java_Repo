package edu.middlesex;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Superclass Class Account.
 * 
 */
public class Account {

    private int AccountID;
    private double Balance;
    private ArrayList<String> transactions;
    private double InterestRate;
    
   public Account ()
   {
	   
   }
    
    public  Account (int ID, double Balance, double IntRate)
    {
    	this.AccountID = ID;
    	this.Balance = Balance;
    	this.InterestRate = IntRate;
    	transactions = new ArrayList<String>(); //Initialize transactions array
    	transactions.add("Created account ("+ID +") with initial deposit of $"+ Balance+" .");
    }
    
    //deposit method. Will be overridden.
    public String Deposit (double amount)
    {
    	String rtn=null;
    	if (amount > 0) {
    		this.Balance = this.Balance + amount;
    		transactions.add("Deposit of $" + amount);
    		rtn= "Deposit of $" + String.valueOf(amount);
    	}
		return rtn;
    }
    
    //withdraw method. Will be overridden
    public String withdraw (double amount)
    {
    	String rtn = null;
    	if (amount >0 && amount <= this.Balance) {
    		this.Balance = this.Balance - amount;
    		transactions.add("Withdrawal of $" + amount);
    		rtn = "Withdrawal of $" + String.valueOf(amount);
    	}
    	return rtn;
    	
    }
    
    
    public double getBalance()
    {
    	return this.Balance;
    }
    
    //will be overridden
    public String printTransactions()
    {
    	String rtn=null;
    	for (int i=0; i < transactions.size(); i++) {
    		String element = transactions.get(i);
    		//System.out.println(element);
    		rtn = rtn+"\n"+element;
    	}
    	return rtn;
    }
    
    //get random number
    static int getNextID()
    {
    	return ThreadLocalRandom.current().nextInt(128);
    }
}
