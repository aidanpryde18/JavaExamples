package highroller;

import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {

        TwoDice playerDice = new TwoDice();
        TwoDice computerDice = new TwoDice();
        int playerScore, computerScore, playerWins = 0, computerWins = 0, ties = 0;
        boolean playAgain;
        String repeatResponse;
        Scanner scan = new Scanner(System.in);

        do
        {
            playerDice.roll();
            playerScore = playerDice.getTotalFaceValue();
            System.out.println("\nPlayer Roll");
            System.out.println(playerDice.toString());
            System.out.println("Total: " + playerScore);

            computerDice.roll();
            computerScore = computerDice.getTotalFaceValue();
            System.out.println("\nComputer Roll");
            System.out.println(computerDice.toString());
            System.out.println("Total: " + computerScore);

            if(playerScore > computerScore)
            {
                System.out.println("\nPLAYER WINS");
                playerWins++;
            }
            else if(playerScore < computerScore)
            {
                System.out.println("\nCOMPUTER WINS");
                computerWins++;
            }
            else
            {
                System.out.println("\nIT'S A TIE");
                ties++;
            }

            System.out.println("\nPlayer Wins: " + playerWins);
            System.out.println("Computer Wins: " + computerWins);
            System.out.println("Ties: " + ties);

            //  NEW DEAL SECTION
            //  Program asks for user input if they want to play again
            //  If the first character is a y, then the game repeats. Anything else causes the program to end.

            System.out.println("\nWould you like to play another hand?(Y or N):   ");

            repeatResponse = scan.next();

            if (repeatResponse.substring(0, 1).toUpperCase().equals("Y")) {
                playAgain = true;
                System.out.println("\n");
            }
            else
                playAgain = false;

        }
        while (playAgain);
    }
}
