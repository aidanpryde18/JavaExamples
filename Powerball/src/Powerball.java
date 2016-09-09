import java.util.Random;
import java.util.Scanner;

public class Powerball {

    public static void main(String[] args) {
	    int numberOfPlayers = 20;
        int[] playerNumbers = new int[numberOfPlayers];
        Random powerballNumber = new Random();
        int winningNumber;
        boolean playAgain = false;
        Scanner scan = new Scanner(System.in);
        String repeatResponse;

        do
        {
            winningNumber = powerballNumber.nextInt(35) + 1;

            for (int i = 0; i < numberOfPlayers; i++)
            {
                playerNumbers[i] = powerballNumber.nextInt(35) + 1;
            }

            System.out.println("Welcome to Powerball! You have to play to win!\n");

            System.out.println("\tThe Winning Powerball Number for today is: " + winningNumber + "\n");

            System.out.println("\tHere are the players for today:\n");

            for (int i = 0; i < numberOfPlayers; i++)
            {
                if (playerNumbers[i] != winningNumber) {
                    System.out.println("\tPlayer " + (i + 1) + ":\t" + playerNumbers[i]);
                } else {
                    System.out.println("\tPlayer " + (i + 1) + ":\t" + playerNumbers[i] + "\t*** We have a winner ***");
                }
            }

            System.out.println("\nWould you like to play again?(Y or N):   ");

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
