/*
 * William Wyatt
 * 3/2/16
 * CIT 249 Java II
 * Tic-Tac-Toe Assignment
 *
 * This program plays a game of tic tac toe between two players.
 */
package tictactoeconsole;
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
 //   toString method to display the board.
 //-------------------------------------------------------------------------------------------

    public String toString(){
        String output = "-------------\n" +
                        "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n" +
                        "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |\n" +
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

 //-------------------------------------------------------------------------------------------
 //   A recursive method to count the number of tokens of a specific type in a column
 //-------------------------------------------------------------------------------------------
    public int countTokensInColumn(String token, int rowPointer, int colPointer)
    {
        int result;

            if (rowPointer == 2){
                if (board[rowPointer][colPointer].equals(token))
                    result = 1;
                else
                    result = 0;
            }
            else if (board[rowPointer][colPointer].equals(token))
                    result = 1 + countTokensInColumn(token, (rowPointer + 1), colPointer);
            else
                result =  0 + countTokensInColumn(token, (rowPointer + 1), colPointer);

            return result;
    }
//-------------------------------------------------------------------------------------------
//   A recursive method to count the number of tokens of a specific type in the 753 diagonal
//-------------------------------------------------------------------------------------------
    public int countTokensInDownDiagonal(String token, int rowPointer, int colPointer)
    {
        int result;

            if (rowPointer == 2 && colPointer == 2){
                if (board[rowPointer][colPointer].equals(token))
                    result = 1;
                else
                    result = 0;
            }
            else if (board[rowPointer][colPointer].equals(token))
                    result = 1 + countTokensInDownDiagonal(token, (rowPointer + 1), (colPointer + 1));
            else
                result =  0 + countTokensInDownDiagonal(token, (rowPointer + 1), (colPointer + 1));

            return result;
    }
//-------------------------------------------------------------------------------------------
//   A recursive method to count the number of tokens of a specific type in the 159 diagonal
//-------------------------------------------------------------------------------------------
    public int countTokensInUpDiagonal(String token, int rowPointer, int colPointer)
    {
        int result;

            if (rowPointer == 0 && colPointer == 2){
                if (board[rowPointer][colPointer].equals(token))
                    result = 1;
                else
                    result = 0;
            }
            else if (board[rowPointer][colPointer].equals(token))
                    result = 1 + countTokensInUpDiagonal(token, (rowPointer - 1), (colPointer + 1));
            else
                result =  0 + countTokensInUpDiagonal(token, (rowPointer - 1), (colPointer + 1));

            return result;
    }
//-------------------------------------------------------------------------------------------
//  A method to determine if a player has won the game.
//  It calls each of the countToken methods to check each win combination.
//  If statements are used after the first check to save processing cycles
//  by preventing redundant checks.
//-------------------------------------------------------------------------------------------
    public boolean checkForWin(String token){
        int result = 0, test = 0;

        for (int row = 0; row < (maxRows); row++){
            test = this.countTokensInRow(token, row, 0);

            if (test == 3){
                result = test;
            }
        }

        if (result != 3)
        {
           for (int col = 0; col < (maxColumns); col++)
           {
            test = this.countTokensInColumn(token, 0, col);

            if (test == 3)
                result = test;
           }
        }

        if (result != 3)
        {
            test = this.countTokensInDownDiagonal(token, 0, 0);

            if (test == 3)
                result = test;
        }

        if (result !=3)
        {
            test = this.countTokensInUpDiagonal(token, 2, 0);

            if (test == 3)
                result = test;
        }

        if (result == 3)
            return true;
        else
            return false;

    }
//-------------------------------------------------------------------------------------------
//  A method to attempt to place the player's selection. It converts the number input
//  into a coordinate on the board and calls the play method to check availability.
//  If the space is empty the token is placed and control returns to the driver.
//  If the space is full, the method returns false and the driver prompts the user
//  to select a new space.
//-------------------------------------------------------------------------------------------
    public boolean makeSelection(int spaceChosen, String currentTokenValue){
        boolean status = false;

        switch (spaceChosen)
            {
                case 1:
                    status = this.play(currentTokenValue, 2, 0);
                    break;
                case 2:
                    status = this.play(currentTokenValue, 2, 1);
                    break;
                case 3:
                    status = this.play(currentTokenValue, 2, 2);
                    break;
                case 4:
                    status = this.play(currentTokenValue, 1, 0);
                    break;
                case 5:
                    status = this.play(currentTokenValue, 1, 1);
                    break;
                case 6:
                    status = this.play(currentTokenValue, 1, 2);
                    break;
                case 7:
                    status = this.play(currentTokenValue, 0, 0);
                    break;
                case 8:
                    status = this.play(currentTokenValue, 0, 1);
                    break;
                case 9:
                    status = this.play(currentTokenValue, 0, 2);
                    break;
        }
        return status;

    }
//-------------------------------------------------------------------------------------------
//  This method reverses the token at the end of each turn so that the opposing player
//  can make their selection on the next turn.
//-------------------------------------------------------------------------------------------
    public boolean reverseToken(boolean currentToken)
    {
        if (currentToken)
            return false;
        else
            return true;
    }


}
