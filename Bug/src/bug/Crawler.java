//************************************************************************
//	Crawler.java
//
//
//************************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Crawler extends Bug
{

	//***********************************************************************************
	//  Instance variables
	//***********************************************************************************

	private int legs;

	//***********************************************************************************
	//  Constructors
	//***********************************************************************************

	public Crawler(String name, ImageIcon image, String direction, int legs)
	{		super(name, image, direction, 1);

		if (!(direction.equals("East") || direction.equals("West")))
			direction = "East";


		this.legs = legs;
	}


	//***********************************************************************************
	//  Accessors
	//***********************************************************************************

	public int getLegs()
	{ return legs;
	}

	//***********************************************************************************
	//  Mutators
	//***********************************************************************************

	public void setLegs(int legs)
	{ this.legs = legs;
	}


	//***********************************************************************************
	//  Additional Methods
	//***********************************************************************************

	public String toString()
	{
		return super.toString() + "and has " + legs + " creepy crawly legs.";
	}

	public boolean canMove(GridPanel bugGrid, int newRow, int newColumn)
		{   if (bugGrid.containsToken(newRow, newColumn))
				return false;
			else
				return true;
		}

public void move(GridPanel bugGrid)
	{
		if (direction == "East" && column == bugGrid.getBoardColumns()-1)
			direction = "West";
		else if (direction == "West" && column == 0)
			direction = "East";

		if (direction == "West")
		{  	   column--;
			   if (canMove(bugGrid, row, column))
			   {  bugGrid.addImage(null, row, column+1);
				  bugGrid.addImage(image, row, column);
			   }
			   else
			   { column++; }
	    }

		else
		{  		column++;
				if (canMove(bugGrid, row, column))
			    {  bugGrid.addImage(null, row, column-1);
				   bugGrid.addImage(image, row, column);
			    }
			    else
			    { column --; }
		}
   }


}