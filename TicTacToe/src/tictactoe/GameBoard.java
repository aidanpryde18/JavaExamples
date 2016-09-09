/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author AQS242RW
 */
public class GameBoard 
{
  //-----------------------------------------------------------------
  //  Instance data items
  //-----------------------------------------------------------------

	private int maxRows, maxColumns;
  	private String[][] board;


  //-------------------------------------------------------------------------------------------
  //   The constructor for a GameBoard object.  Dashes represent free spaces.
  //-------------------------------------------------------------------------------------------
  public GameBoard(int rows, int columns)
   {  board = new String[rows][columns];

	  for (int i = 0; i < rows; i++)
	  	for (int j = 0; j < columns; j++)
	  		board[i][j] = "-";
	  maxRows = rows;
	  maxColumns = columns;
   }

  //-------------------------------------------------------------------------------------------
  //   A method to check to see if a position on the board is free (open)
  //-------------------------------------------------------------------------------------------
     public boolean isFree(int row, int column)
	   {   if (board[row][column].equals("-")) return true; else return false;    }

  //-------------------------------------------------------------------------------------------
  //   A method to place a token on the board, if possible
  //-------------------------------------------------------------------------------------------
     public boolean play(String token, int row, int column)
	 {   if (isFree(row, column))
	   	 {	board[row][column] = token;
	   			return true;  }
		 else
		   		return false;

	 }

  //-------------------------------------------------------------------------------------------
  //   A method to move a token on the board, if possible
  //-------------------------------------------------------------------------------------------
     public boolean move(int oldRow, int oldColumn, int newRow, int newColumn)
	 {   if (isFree(newRow, newColumn))
	   	 {	board[newRow][newColumn] = board[oldRow][oldColumn];
	   	 	board[oldRow][oldColumn] = "-";
	   		return true;  }
		 else
		   	return false;

	 }

 //-------------------------------------------------------------------------------------------
 //   Create a method to display the board.  Either use toString for console applications
 //   or include a GUI version.
 //-------------------------------------------------------------------------------------------
    public String toString(){
        String output = "-------------\n" + 
                        "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n" +
                        "-------------\n" +
                        "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |\n" +
                        "-------------\n" +
                        "| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |\n" +
                        "-------------\n";
        return output;
    }
 //-------------------------------------------------------------------------------------------
 //   A recursive method to count the number of tokens of a specific type in a row
 //   For example, countTokensInRow("R", 1, 0); would count all R tokens in row 1
 //   starting the counting in column 0.
 //-------------------------------------------------------------------------------------------
    public int countTokensInRow(String token, int rowPointer, int colPointer)
	 {
            int result;
             
            if (colPointer == 2){
                if (board[rowPointer][colPointer].equals(token))
                    result = 1;
                else
                    result = 0;
            }
            else if (board[rowPointer][colPointer].equals(token))
                    result = 1 + countTokensInRow(token, rowPointer, (colPointer + 1));
            else
                result =  0 + countTokensInRow(token, rowPointer, (colPointer + 1));
            
            
            return result;
         }


}
