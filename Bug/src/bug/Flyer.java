//************************************************************************
//	Flyer.java
//
//
//************************************************************************


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Flyer extends Bug
{

	//***********************************************************************************
	//  Instance variables
	//***********************************************************************************

	private int wings;

	//***********************************************************************************
	//  Constructors
	//***********************************************************************************

	public Flyer(String name, ImageIcon image, String direction, int wings)
	{		super(name, image, direction, 1);

		if (!(direction.equals("North") || direction.equals("South")))
			direction = "North";


		this.wings = wings;
	}


	//***********************************************************************************
	//  Accessors
	//***********************************************************************************

	public int getWings()
	{ return wings;
	}

	//***********************************************************************************
	//  Mutators
	//***********************************************************************************

	public void setWings(int wings)
	{ this.wings = wings;
	}


	//***********************************************************************************
	//  Additional Methods
	//***********************************************************************************

	public String toString()
	{
		return super.toString() + "and has " + wings + " sets of wings.";
	}

	public boolean canMove(GridPanel bugGrid, int newRow, int newColumn)
		{   if (bugGrid.containsToken(newRow, newColumn))
				return false;
			else
				return true;
		}

public void move(GridPanel bugGrid)
	{
		if (direction == "North" && row == bugGrid.getBoardColumns()-1)
			direction = "South";
		else if (direction == "South" && row == 0)
			direction = "North";

		if (direction == "South")
		{  	   row--;
			   if (canMove(bugGrid, row, column))
			   {  bugGrid.addImage(null, row+1, column);
				  bugGrid.addImage(image, row, column);
			   }
			   else
			   { row++; }
	    }

		else
		{  		row++;
				if (canMove(bugGrid, row, column))
			    {  bugGrid.addImage(null, row-1, column);
				   bugGrid.addImage(image, row, column);
			    }
			    else
			    { row--; }
		}
   }


}