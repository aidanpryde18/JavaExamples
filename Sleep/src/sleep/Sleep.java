/*
 * William Wyatt
 * 1/19/16
 * CIT 149 Java I
 * Sleep Assignment
 *
 * This program calculates the estimated total time in a person's life
 * that they have spent asleep.
 */

import java.util.Scanner;

public class Sleep {


    public static void main(String[] args) {
       //Variable Declarations. These store user input and calculated values
       String userName;
       int userAge;
       double avgSleep;
       double hoursSlept;
       double daysSlept;
       double yearsSlept;

       //Constants used for calculation
       final int DAYS_IN_YEAR = 365;
       final int HOURS_IN_DAY = 24;

       //Creates an instance of the scanner object for gathering user input
       Scanner scan = new Scanner(System.in);

       //User input section. Asks user questions and stores their answers in variables
       System.out.println("Enter your name:");

       userName = scan.nextLine();

       System.out.println("Enter your age(in years):");

       userAge = scan.nextInt();

       System.out.println("How much sleep, on average, do you get each night:");

       avgSleep = scan.nextDouble();


       //Sleep calculations. IT calculates the number of days they've been alive
       //and then multiplies that by their average hours slept per day.
       hoursSlept = (userAge * DAYS_IN_YEAR) * avgSleep;

       //Divides hours slept by 24 to get days slept.
       daysSlept = hoursSlept / HOURS_IN_DAY;

       //Divides days slept by 365 to get years slept.
       yearsSlept = daysSlept / DAYS_IN_YEAR;

       //Output to let the user know the results of the calculations.
       //Nicely formatted to output multiple lines.
       System.out.println("\nHi " + userName + ",\n \n"
                            + "Here is how long you have slept in your lifetime:\n \n"
                            + "You have slept for a total of " + hoursSlept + " hours\n"
                            + "You have slept for a total of " + daysSlept + " days\n"
                            + "You have slept for a total of " + yearsSlept + " years\n");

    }
}
