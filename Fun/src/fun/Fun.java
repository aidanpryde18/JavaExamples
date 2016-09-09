/*
 * William Wyatt
 * 2/9/16
 * CIT 149 Java I
 * Fun Calendar Assignment
 *
 * This program takes input from the user and prints
 * a listing of the holidays for the rest of the school year, by month.
 */

import java.util.Scanner;

public class Fun {

    public static void main(String[] args)
    {
        int month;


        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the numeric month(1-12):");

        month = scan.nextInt();

        /*  Switch Statement analyzes the month variable and starts printing from that month until the end of the year.
         *  The break in case 12 prevents the default(error) statement from printing if a valid month is input.
         */
        switch (month)
        {
            case 1:
                System.out.println("\nOur Fun Days in January:\n\tNew Year's Day\n\tMartin Luther King Jr.'s Birthday");
            case 2:
                System.out.println("Our Fun Days in February:\n\tGroundhog Day\n\tPresidents' Day\n\tValentine's Day");
            case 3:
                System.out.println("Our Fun Days in March:\n\tSt. Patrick's Day\n\tVernal Equinox");
            case 4:
                System.out.println("Our Fun Days in April:\n\tApril Fool's Day\n\tEarth Day");
            case 5:
                System.out.println("Our Fun Days in May:\n\tMother's Day\n\tMemorial Day");
            case 6:
                System.out.println("Our Fun Days in June:\n\tFather's Day\n\tSummer Solstice");
            case 7:
                System.out.println("Our Fun Days in July:\n\tIndependence Day\n\tWorld Youth Day");
            case 8:
                System.out.println("Our Fun Days in August:\n\tNational Watermelon Day\n\tNational S'mores Day");
            case 9:
                System.out.println("Our Fun Days in September:\n\tGrandparents' Day\n\tAutumnal Equinox");
            case 10:
                System.out.println("Our Fun Days in October:\n\tMake A Difference Day\n\tHalloween");
            case 11:
                System.out.println("Our Fun Days in November:\n\tVeteran's Day\n\tThanksgiving Day");
            case 12:
                System.out.println("Our Fun Days in December:\n\tWinter Solstice\n\tChristmas");
                break;
            default:
                System.out.println("Month entered is not valid.");
        }

    }

}
