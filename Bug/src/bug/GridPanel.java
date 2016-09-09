//********************************************************************
//  GridPanel.java       Java Foundations
//
//  A grid panel to represent a  game board of buttons (8x8 default).
//  The buttons use an ImageIcon to display the playing "pieces"
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class GridPanel extends JPanel
{
  //-----------------------------------------------------------------
  //  Sets up this panel with some buttons to show how grid
  //  layout affects their position, shape, and size.
  //-----------------------------------------------------------------

  //-----------------------------------------------------------------
  //  The only instance data item is an 8x8 array of buttons
  //-----------------------------------------------------------------
  private int rows, columns;
  private JButton[][] buttonArray;

  //-------------------------------------------------------------------------------------------
  //   The constructor for the panel.  This sets up the array using a GridLayout GUI component
  //   The text on each button is blank and no ImageIcons are loaded.
  //-------------------------------------------------------------------------------------------
  public GridPanel(int rows, int columns)
   {
      if (rows > 0 && columns > 0)
      { this.rows = rows;
        this. columns = columns;
        buttonArray = new JButton[rows][columns];
      	setLayout(new GridLayout(rows,columns)); 	}
      else
      { rows = 8;
        columns = 8;
        buttonArray = new JButton[8][8];
        setLayout(new GridLayout(8,8));				}

      setBackground(Color.green);


	  for (int i = 0; i < rows; i++)
	  	for (int j = 0; j < columns; j++)
	  		buttonArray[i][j] = new JButton(" ");

      for (int i = 0; i < rows; i++)
	  	for (int j = 0; j < columns; j++)
      		add(buttonArray[i][j]);

   }

  //-------------------------------------------------------------------------------------------
  //   Accessors to return board size
  //-------------------------------------------------------------------------------------------
   public int getBoardRows()
   { return rows;   }


    public int getBoardColumns()
   { return columns;   }


//-------------------------------------------------------------------------------------------
  //   A method to add an ImageIcon image to a specific position on the board
  //-------------------------------------------------------------------------------------------
   public void addImage(ImageIcon image, int row, int col)
   {
	   if (row < rows && row >= 0 && col < columns && col >=0)
	   		buttonArray[row][col].setIcon(image);
    }
  //-------------------------------------------------------------------------------------------
  //   A method to check to see if an image (playing piece) contains exists on the board
  //-------------------------------------------------------------------------------------------
     public boolean containsToken(int row, int col)
	   {
		   if (buttonArray[row][col].getIcon() != null) return true; else return false;

    }

}
