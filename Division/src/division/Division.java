/*
 * William Wyatt
 * 1/19/16
 * CIT 149 Java I
 * Division Assignment
 *
 * This program calculates the cost of a monthly text messaging
 * plan, based on the number of texts input by the user.
 */
package division;

// This imports the Scanner class so that the program can read input
import java.util.Scanner;

public class Division {

    
    public static void main(String[] args) {

        /* I used variables for all of my calculations to make it easy to read
         * and understand the calculations. Also, in the event that the user
         * changes their cell phone plan, it would be simple to come in and change the
         * values of the constants and not have to worry about changing the 
         * value in a calculation.
         */

        int textsUsed, blocksUsed, remainder;
        double totalCost;
        final int BLOCK_SIZE = 200;
        final double BLOCK_CHARGE = 5.25;
        final double PER_MESSAGE = .03;
        
        //This creates an instance of the Scanner object
        Scanner scan = new Scanner(System.in);
        
        //Prompt for user to input the number of texts they've used
        System.out.println("How many text messages did you use:");
        
        //Saves the users input to a variable for processing
        textsUsed = scan.nextInt();
        
        //Integer division to find the number of full blocks the user used
        blocksUsed = textsUsed / BLOCK_SIZE;
        
        //Modulo division to find the number of individual texts used
        remainder = textsUsed % BLOCK_SIZE;
        
        //Calculation of total cost. Multiplies the blocks used time the cost per block
        //and the individual messages used times the individual message charge.
        //It takes those two numbers and adds them together to get the total monthly cost.
        totalCost = (blocksUsed * BLOCK_CHARGE) + (remainder * PER_MESSAGE);
        
        //After calculation, the number is sent to the command line to let the user
        //know what their monthly cost is.
        System.out.println("You used " + textsUsed 
                             + " text messages for a total cost of $" + totalCost);
    }
}
