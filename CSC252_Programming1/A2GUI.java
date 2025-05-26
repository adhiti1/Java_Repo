package edu.middlesex;

/*
Program: 		A2Scanner.java
Written by:		Adhiti Venkatesh
Description:	Tip Calculator using Scanner
Challenges::	working with JOption Pane window. 
				Concatenating and showing one message for tip and final bill
				Error checking if it is numeric and tip is one of the 3 values
Time Spent:		9 hours

                Revision History
Date:                   By:               Action:
---------------------------------------------------
02/01/2024				AV					Created
02/03/2024				AV					Error Checking code
02/03/2024				AV					Error Checking
02/04/2024				AV					Debugging
02/05/2024				AV					Debugging and Documentation
02/06/2024				AV					Debugging
*/

import javax.swing.JOptionPane; 

public class A2GUI {

	public static void main(String[] args) {
	
		double cost;
		String sCost;

		cost=0;		
		do {
	         sCost = JOptionPane.showInputDialog("Please Enter the cost of your meail:"); 
	         try {
	        	  cost = Double.parseDouble(sCost); //parse input
	        	} 
	         catch (NumberFormatException e) {
	        	  //the parseDouble failed. Show error message
			        JOptionPane.showMessageDialog(null, "Cost should be numeric.");
	        	} 
	        
//check if cost is positive.			
			if (cost < 0) {
		        JOptionPane.showMessageDialog(null, "Cost of meal should be greater than zero. Please re-enter cost."); 				
			}
			} while (cost <=0);
        
 //       JOptionPane.showMessageDialog(null, "cost " + String.format("%.2f", cost)); 

		//Get Tip percentage		
			int tipPct;
			String sTipPct;
			
			tipPct=0;
			do {
		         sTipPct = JOptionPane.showInputDialog("What percentage would you like to tip (15 or 18 or 20):"); 
		//make sure tip pct is valid number
		         try {
		        	  tipPct = Integer.parseInt(sTipPct); //Parse it as integer
		        	} 
		         catch (NumberFormatException e) {
		        	  //the parseDouble failed and show error message
				        JOptionPane.showMessageDialog(null, "Tip Pct. should be numeric.");
		        	} 

		         //make sure tip pct is one of the 3 valid numbers.			
					if ( tipPct != 15 && tipPct !=18 && tipPct !=20 ) {
				        JOptionPane.showMessageDialog(null, "Tip Pct. should be either 15 or 18 or 20.");
					}					
				} while (tipPct != 15 && tipPct !=18 && tipPct !=20);
			
			double tip = tipPct*cost/100;
			
			String Message; //show tip amount and final bill in one window. use this variable
			
			Message = "Your tip amount is: " + "$"+String.format("%.2f", tip);
			
			double totalAmount = tip+cost;
			Message = Message +"\n"+ "Your Bill + tip is: " + "$" + String.format("%.2f", totalAmount);
			
			JOptionPane.showMessageDialog(null, Message);

			int partyCount;
			String sPartyCount;
			
			partyCount = 0;
			do {
				sPartyCount = JOptionPane.showInputDialog("How many people would you like to split bill with? "); 
	//make sure party count is valid integer.
		         try {
		        	 partyCount = Integer.parseInt(sPartyCount); //parse integer
		        	} 
		         catch (NumberFormatException e) {
		        	  //the parseDouble failed and show error message
				        JOptionPane.showMessageDialog(null, "Count of Party should be numeric.");
		        	} 
	//make sure party count is positive.			
				if (partyCount <= 0) {
			        JOptionPane.showMessageDialog(null, "Count of Party should be greater than zero.");	
				}
			} while (partyCount <=0);

			
			double costPerPerson ;
			
			costPerPerson= totalAmount/partyCount;
	        JOptionPane.showMessageDialog(null, "Each person's share is: " + "$"+String.format("%.2f", costPerPerson));	

	}
}

