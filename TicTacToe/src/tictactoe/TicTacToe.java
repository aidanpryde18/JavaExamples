/*
 * William Wyatt
 * 3/2/16
 * CIT 249 Java II
 * Tic-Tac-Toe Assignment
 *
 * This program places tokens on a board and then counts the number of tokens in each row.
 */
package tictactoe;

public class TicTacToe
{
//      Main Method creates the game board, places some pieces 
//      and prints the board and count of pieces per row for each type.
   public static void main(String[] args)
   {
      GameBoard newGame = new GameBoard(3, 3);
      
      newGame.play("X", 0, 0);
      newGame.play("O", 1, 0);
      newGame.play("X", 0, 1);
      newGame.play("O", 1, 2);
      newGame.play("X", 0, 2);
      
      System.out.print(newGame);
      
      System.out.println("\nX Tokens in row 1: " + (newGame.countTokensInRow("X", 0, 0)));
      System.out.println("\nO Tokens in row 1: " + (newGame.countTokensInRow("O", 0, 0)));
      System.out.println("\nO Tokens in row 2: " + (newGame.countTokensInRow("O", 1, 0)));
      System.out.println("\nX Tokens in row 2: " + (newGame.countTokensInRow("X", 1, 0)));
      System.out.println("\nO Tokens in row 3: " + (newGame.countTokensInRow("O", 2, 0)));
      System.out.println("\nX Tokens in row 3: " + (newGame.countTokensInRow("X", 2, 0)));
      
      
      //        Determines if there is a winner
      
      for (int row = 0; row < 3; row++)
      {
          if (newGame.countTokensInRow("X", row, 0) == 3)
              System.out.println("\nX Has won the game!!!!");
      }
      
      for (int row = 0; row < 3; row++)
      {
          if (newGame.countTokensInRow("O", row, 0) == 3)
              System.out.println("\nO Has won the game!!!!");
      }
   }
}