//********************************************************************
//  BorderPanel.java       Java Foundations
//
//  A border panel to hold the buttons and the bugs game board.
//  This is the main panel that students will use.
//
//  THIS IS AN INCOMPLETE CLASS - STUDENTS MODIFY THIS FOR HOMEWORK
//  BY INSTANTIATING NEW BUGS, PLACING THEM ON THE BOARD, AND MOVING
//  THEM.
//*******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class BorderPanel extends JPanel
{
   //-----------------------------------------------------------------
   //  Sets up this panel with a button in each area of a border
   //  layout to show how it affects their position, shape, and size.
   //-----------------------------------------------------------------

   private JPanel buttonPanel = new JPanel();
   private JButton startButton = new JButton("Start the Game");
   private JButton stopButton = new JButton("Stop the Game");
   private JButton moveButton = new JButton("Move the Bugs");
   private ButtonListener listener = new ButtonListener();
   private GridPanel bugGrid;
   private ImageIcon flyerImage = new ImageIcon("resources/Flyer.png");
   private ImageIcon crawlerImage = new ImageIcon("resources/Crawler.png");
   private ImageIcon bigCrawlerImage = new ImageIcon("resources/BigCrawler.png");

   private Crawler crawlerBug1;
   private Crawler crawlerBug2;
   private Flyer flyerBug1;
   private BigCrawler bigCrawlerBug1;

   private final static int BOARD_ROWS = 8;
   private final static int BOARD_COLUMNS = 8;

   public BorderPanel()

   {
      bugGrid = new GridPanel(BOARD_ROWS, BOARD_COLUMNS);

      //--------------------------------------------------
      // Create a simple panel for the three buttons
      //--------------------------------------------------
	  stopButton.addActionListener(listener);
	  startButton.addActionListener(listener);
	  moveButton.addActionListener(listener);
	  buttonPanel.add(startButton);
	  buttonPanel.add(stopButton);
	  buttonPanel.add(moveButton);


      //--------------------------------------------------
      // Use a BorderLayout for the game
      //--------------------------------------------------

      setLayout(new BorderLayout());
      setBackground(Color.green);


	  //--------------------------------------------------
      // Add the buttonPanel and the grid to the
      // BorderPanel
      //--------------------------------------------------
      add(buttonPanel, BorderLayout.NORTH);
      add(bugGrid, BorderLayout.CENTER);
   }


   private class ButtonListener implements ActionListener
   	{
   		public void actionPerformed(ActionEvent event)
   		{
   			if (event.getSource() == stopButton) {
		 		System.exit (0);	}

   			if (event.getSource() == startButton) {
   			  //------------------------------------------------------------
			  // Sample of placing 2 Crawler bugs on the grid at a random
			  // locations.
			  //------------------------------------------------------------
				Random generator = new Random();
				crawlerBug1 = new Crawler("Spider", crawlerImage, "East",  8);

				int row = generator.nextInt(bugGrid.getBoardRows()) ;
				int column = generator.nextInt(bugGrid.getBoardColumns());

			  //------------------------------------------------------------
			  // First crawler bug is placed on the board
			  //------------------------------------------------------------
				while (bugGrid.containsToken(row,column))
				{	row = generator.nextInt(bugGrid.getBoardRows()) ;
				    column = generator.nextInt(bugGrid.getBoardColumns()); }

				crawlerBug1.setRow(row);
				crawlerBug1.setColumn(column);
				bugGrid.addImage(crawlerImage,crawlerBug1.getRow(), crawlerBug1.getColumn());

			  //------------------------------------------------------------
			  // Second crawler bug is placed on the board
			  //------------------------------------------------------------
				crawlerBug2 = new Crawler("Creepy Crawler", crawlerImage, "West",  22);

				row = generator.nextInt(bugGrid.getBoardRows()) ;
				column = generator.nextInt(bugGrid.getBoardColumns());

				while (bugGrid.containsToken(row,column))
				{	row = generator.nextInt(bugGrid.getBoardRows()) ;
				    column = generator.nextInt(bugGrid.getBoardColumns()); }

				crawlerBug2.setRow(row);
				crawlerBug2.setColumn(column);
				bugGrid.addImage(crawlerImage,crawlerBug2.getRow(), crawlerBug2.getColumn());

   		    
		  	  //------------------------------------------------------------
			  // You should instantiate and place a flyer bug on the board
			  // after this comment
			  //------------------------------------------------------------

                                flyerBug1 = new Flyer("Bumblebee", flyerImage, "North", 2);
                                
                                row = generator.nextInt(bugGrid.getBoardRows());
                                column = generator.nextInt(bugGrid.getBoardColumns());
                                
                                while (bugGrid.containsToken(row,column))
				{	row = generator.nextInt(bugGrid.getBoardRows()) ;
				    column = generator.nextInt(bugGrid.getBoardColumns()); }

				flyerBug1.setRow(row);
				flyerBug1.setColumn(column);
				bugGrid.addImage(flyerImage,flyerBug1.getRow(), flyerBug1.getColumn());
                                
                                bigCrawlerBug1 = new BigCrawler("Centipede", bigCrawlerImage, "NorthEast",  100);

				row = generator.nextInt(bugGrid.getBoardRows()) ;
				column = generator.nextInt(bugGrid.getBoardColumns());

			 
				while (bugGrid.containsToken(row,column))
				{	row = generator.nextInt(bugGrid.getBoardRows()) ;
				    column = generator.nextInt(bugGrid.getBoardColumns()); }

				crawlerBug1.setRow(row);
				crawlerBug1.setColumn(column);
				bugGrid.addImage(bigCrawlerImage,bigCrawlerBug1.getRow(), bigCrawlerBug1.getColumn());

                    }   



			if (event.getSource() == moveButton) {
 			  //------------------------------------------------------------
			  // Sample of moving a bug on the grid
			  //------------------------------------------------------------
				crawlerBug1.move(bugGrid);
                                crawlerBug2.move(bugGrid);
                                

			  //------------------------------------------------------------
			  // You should move the flyer bug after this comment
			  //------------------------------------------------------------

                                flyerBug1.move(bugGrid);
                                bigCrawlerBug1.move(bugGrid);


   			}
   		}
	}
}
