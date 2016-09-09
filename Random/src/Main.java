import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        boolean guessAgain = false;
        int randomNumber = rand.nextInt(50) + 1;
        int numberOfGuesses = 0;
        String playerInput;
        int playerGuess;
        Scanner scan = new Scanner(System.in);

        do
        {
            System.out.println("Guess a number(1-50) or quit(quit or exit): ");
            playerInput = scan.next();

            if(Integer.parseInt(playerInput))
            numberOfGuesses++;

            if(playerGuess == randomNumber)
            {
                System.out.println("That is correct!");
                System.out.println("Total Guesses: " + numberOfGuesses);
                System.exit(0);
            }


        }
        while (guessAgain == true);





    }
}
