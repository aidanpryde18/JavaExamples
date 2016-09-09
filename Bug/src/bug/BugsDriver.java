//********************************************************************
//  LayoutDemo.java       Java Foundations
//
//  Driver for the bugs game
//********************************************************************

import javax.swing.*;

public class BugsDriver
{
   //-----------------------------------------------------------------
   //  Sets up a frame containing a tabbed pane. The panel on each
   //  tab demonstrates a different layout manager.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Move the Bugs");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      BorderPanel bugsGame = new BorderPanel();


      frame.getContentPane().add(bugsGame);

      frame.pack();
      frame.setVisible(true);
   }
}
