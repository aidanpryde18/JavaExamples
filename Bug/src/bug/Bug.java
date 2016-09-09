//************************************************************************
//	Bug.java
//
//  An abstract class of Bugs
//************************************************************************


package bu
import java.awt.*;
import javax.swing.*;
abstract public class Bug
{

	//***********************************************************************************
	//  Instance variables
	//***********************************************************************************
	protected String name,direction;
	protected ImageIcon image = new ImageIcon();
	protected int distance, row, column;

	//***********************************************************************************
	//  Constructors
	//
	//  Default constructor sets location to position -1, -1 (off board)
	//***********************************************************************************

	public Bug (String name, ImageIcon image, String direction, int distance)
	{
		this.name = name;
		this.image = image;
		this.direction = direction;
		this.distance = distance;
		this.row = -1;
		this.column = -1;
	}

	public Bug ()
		{	this.name = "";
			this.image = null;
			this.direction = "";
			this.distance = 1;
			this.row = -1;
			this.column = -1;
	}

   	//***********************************************************************************
	//  Accessors
	//***********************************************************************************

	public String getName()
		{ return name; }

	public ImageIcon getImage()
		{ return image; }

	public String getDirection()
		{ return direction; }

	public int getDistance()
		{ return distance; }

	public int getRow()
		{ return row; }

	public int getColumn()
		{ return column; }


	//***********************************************************************************
	//  Mutators
	//***********************************************************************************

	public void setName(String name)
		{	this.name = name;		}

	public void setImage(ImageIcon image)
		{	this.image = image;		}

	public void setDirection(String direction)
		{	this.direction = direction;		}

	public void setDistance(int distance)
		{	this.distance = distance;   	}

	public void setRow(int row)
		{	this.row = row;   	}

	public void setColumn(int column)
		{ 	this.column = column; }


	//***********************************************************************************
	//  Additional Methods
	//***********************************************************************************

 	public String toString()
	{
		return ("Name: " + name +  "\tDirection: " + direction + "\tDistance: " + distance + "\nPosition: "+ row + "," + column + "\n");
	}

	public  abstract boolean canMove(GridPanel bugGrid, int newRow, int newColumn);
	public  abstract void move(GridPanel bugGrid);

}

