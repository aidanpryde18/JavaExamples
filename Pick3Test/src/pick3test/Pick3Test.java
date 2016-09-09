/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pick3test;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author AQS242RW
 */
public class Pick3Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      final int NUMBEROFPLAYERS = 20;
        final int NUMBEROFBALLS = 3;
        int[][] playerNumbers = new int[NUMBEROFPLAYERS][NUMBEROFBALLS];
        Random pick3Number = new Random();
        int[] winningNumbers = new int[NUMBEROFBALLS];
        boolean playAgain = false;
        Scanner scan = new Scanner(System.in);
        String repeatResponse;

        do
        {
            for (int ball = 0; ball < NUMBEROFBALLS; ball++)
            {
                winningNumbers[ball] = pick3Number.nextInt(10);    //Selects the Winning Numbers Randomly
            }

            intInsertionSort(winningNumbers);

            //	Randomly selects player's numbers and assigns them to an array

            for (int player = 0; player < NUMBEROFPLAYERS; player++)
            {
                for (int ball = 0; ball < NUMBEROFBALLS; ball++)
                {
                    playerNumbers[player][ball] = pick3Number.nextInt(10);
                }
                intInsertionSort(playerNumbers[player]);
            }

            //	HEADER SECTION

            System.out.println("Welcome to Pick 3! You have to play to win!\n");

            System.out.println("\tThe Winning Pick 3 numbers are: " + winningNumbers[0] + " " + winningNumbers[1] + " " + winningNumbers[2] + "\n");

            System.out.println("\tHere are the players for today:\n");

            //	PLAYER NUMBER OUTPUT	Compares chosen numbers to winning numbers and shows the winning player if they match.

            for (int player = 0; player < NUMBEROFPLAYERS; player++)
            {
                if (playerNumbers[player][0] == winningNumbers[0] && playerNumbers[player][1] == winningNumbers[1] && playerNumbers[player][2] == winningNumbers[2])
                {
                    System.out.println("\tPlayer " + (player + 1) + ":\t" + playerNumbers[player][0] + " " + playerNumbers[player][1] + " " + playerNumbers[player][2] + "\t*** We have a winner ***");
                }
                else
                {
                    System.out.println("\tPlayer " + (player + 1) + ":\t" + playerNumbers[player][0] + " " + playerNumbers[player][1] + " " + playerNumbers[player][2]);
                }
            }

            //	REPLAY SECTION	Takes user input to see if they would like to restart the powerball program.

            System.out.println("\nWould you like to play again?(Y or N): ");

            repeatResponse = scan.next();

            if (repeatResponse.substring(0, 1).toUpperCase().equals("Y"))
            {
                playAgain = true;
                System.out.println("\n");
            }
            else
                playAgain = false;
        }
        while (playAgain);

    }



private static void intInsertionSort(int[] a)
{
	for (int i = 1; i < a.length; i++)
	{
		int temp = a[i];
		int j;

		for (j = i - 1; j >= 0 && temp < a[j]; j--)
		{
			a[j+1] = a[j];
		}
		a[j+1] = temp;
	}
}

}