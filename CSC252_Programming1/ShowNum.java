package edu.middlesex;

public class ShowNum {
	private int row; //stores row
	private int col; //stores columb
	
	public ShowNum() { //default constructor
		row =0;
		col=0;
	};
	
	public ShowNum(int row, int col) //constructor with row and col passed as parameter
	{
		this.row = row;
		this.col = col;
	}
	
	public void setRow(int row) //sets row
	{
		this.row = row;
	}
	public int getRow() //gets row from object
	{
		return this.row;
	}
	public void setCol(int col) //sets column
	{
		this.col = col;
	}
	public int getCol() //get scol from object.
	{
		return this.col;
	}
	
	public void display() //displays asterix for rows and cols
	{
		System.out.println("Inputs:  "+row+", "+col);
		for (int i=0;i < this.row; i++)
		{
			for (int j=0; j<this.col; j++)
				System.out.print("*");
			System.out.print("\n");	
		}
	}

}
