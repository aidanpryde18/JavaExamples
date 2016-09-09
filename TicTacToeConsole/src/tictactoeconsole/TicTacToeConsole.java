/*
 * William Wyatt
 * 3/2/16
 * CIT 249 Java II
 * Tic-Tac-Toe Assignment
 *
 * This program plays a game of tic tac toe between two players.
 */
package tictactoeconsole;
import java.util.Scanner;

public class TicTacToeConsole {

    public static void main(String[] args) {
        boolean currentToken; // true = X, false = O
        boolean playAgain = true; //Initialized as true so the game plays the first time
        boolean winner;
        int emptySpacesRemaining;
        String currentTokenValue;
        String repeatResponse;

        int spaceChosen;

        Scanner scan = new Scanner(System.in);

        //      RULES PRINTOUT

        System.out.println("\t\tTic-Tac-Toe\n");
        System.out.println("RULES: This is a standard game of Tic-Tac-Toe. X goes first\n" +
                            "and places a token on the board, followed by O.\n" +
                            "To place a token on the board, when prompted, enter a number\n" +
                            "between 1-9 corresponding with the space where you want the token placed.\n" +
                            "Using the NumPad on your keyboard corresponds perfectly to the board spaces.\n" +
                            "Play will alternate until one player fills a row with their token.\n");

        System.out.println("-------------\n" +
                            "| 7 | 8 | 9 |\n" +
                            "| 4 | 5 | 6 |\n" +
                            "| 1 | 2 | 3 |\n" +
                            "-------------\n");


        //      LOOPS THE GAME UNTIL THE PLAYERS QUIT
        while(playAgain)
        {

            //      SETS CONDITIONS FOR A NEW GAME
            GameBoard currentGame = new GameBoard(3,3);
            winner = false;
            emptySpacesRemaining = 9;
            currentToken = true;
            currentTokenValue = "X";

            //      LOOPS THE GAME UNTIL A SOMEONE WINS
            while(emptySpacesRemaining > 0 && !winner)
            {
                System.out.print(currentGame);

                if(currentToken)
                    currentTokenValue = "X";
                else
                    currentTokenValue = "O";

                System.out.println(currentTokenValue + ": Pick a space(1-9):   ");

                spaceChosen = scan.nextInt();

                //INPUT VALIDATION FOR VALID AND EMPTY SPACE

                while (spaceChosen < 1 || spaceChosen > 9)
                {
                    System.out.print("Invalid space. Please choose again:   ");
                    spaceChosen = scan.nextInt();
                }

                while(!(currentGame.makeSelection(spaceChosen, currentTokenValue)))
                {
                    System.out.print("Space is taken. Please choose again:   ");
                    spaceChosen = scan.nextInt();
                }
                
                emptySpacesRemaining--;
                
                winner = currentGame.checkForWin(currentTokenValue);

                currentToken = currentGame.reverseToken(currentToken);
            }

            //      WINNING GAME OUTPUT

            System.out.print(currentGame);

            if (emptySpacesRemaining == 0 && !winner)
                System.out.println("\nIT'S A DRAW\n\n");
            else
                System.out.println("\n" + currentTokenValue + " WINS!!!!!!!\n\n");

            System.out.println("\nWould you like to play again?(Y or N):   ");

            repeatResponse = scan.next();

            if (repeatResponse.substring(0, 1).toUpperCase().equals("Y")) {
                playAgain = true;
                System.out.println("\n");
            }
            else
                playAgain = false;

        }
    }

}
