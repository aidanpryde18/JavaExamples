//************************************************************************
//	Crawler.java
//
//
//************************************************************************


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BigCrawler extends Crawler
{

	//***********************************************************************************
	//  Instance variables
	//***********************************************************************************

	private int legs;

	//***********************************************************************************
	//  Constructors
	//***********************************************************************************

	public BigCrawler(String name, ImageIcon image, String direction, int legs)
	{		super(name, image, direction, 1);

		if (!(direction.equals("NorthEast") || direction.equals("SouthWest")))
			direction = "NorthEast";


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
		return super.toString() + "and has " + legs + " massive, creepy crawly legs.";
	}

	public boolean canMove(GridPanel bugGrid, int newRow, int newColumn)
		{   if (bugGrid.containsToken(newRow, newColumn))
				return false;
			else
				return true;
		}

public void move(GridPanel bugGrid)
	{
		if (direction == "NorthEast" && (column == bugGrid.getBoardColumns()-1 || row == bugGrid.getBoardRows()-1))
			direction = "SouthWest";
		else if (direction == "SouthWest" && (column == 0 || row == 0))
			direction = "NorthEast";

		if (direction == "SouthWest")
		{  	   column--;
                           row--;
			   if (canMove(bugGrid, row, column))
			   {  bugGrid.addImage(null, row+1, column+1);
				  bugGrid.addImage(image, row, column);
			   }
			   else
			   { column++; 
                             row++; }
	    }

		else
		{  		column++;
                                row++;
				if (canMove(bugGrid, row, column))
			    {  bugGrid.addImage(null, row-1, column-1);
				   bugGrid.addImage(image, row, column);
			    }
			    else
			    { column--;
                              row--;    }
		}
   }


}