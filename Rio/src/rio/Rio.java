/*
 * William Wyatt
 * 2/2/16
 * CIT 149 Java I
 * Rio Assignment
 *
 * This program calculates the cost of a sweatshirt order
 * and then prints out a receipt for the customer.
 */

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Random;

public class Rio {

    public static void main(String[] args) {
        String date, dateNoDash, firstInput, firstName, lastInput, lastName;
        String confNum, creditType, creditNum, vendorID;
        int childNum, adultNum, randomNum;
        double subTotal, total, tax;
        final double CHILD_COST = 34.50;
        final double ADULT_COST = 62.75;
        final double SALES_TAX = 0.12;

        Scanner scan = new Scanner(System.in);

        NumberFormat dollar = NumberFormat.getCurrencyInstance();

        Random rand = new Random();


        //  INPUT SECTION


        System.out.println("What is the date(MM-DD-YYYY):  ");

        date = scan.nextLine();

        dateNoDash = date.replace("-", "");

        System.out.println("What is the buyer's first name:  ");

        firstInput = scan.nextLine();

        //  This ensures that the First name is in the proper casing for output.
        //  It capitalizes the first letter and changes the rest to lower case.

        firstName = firstInput.substring(0,1).toUpperCase() + firstInput.substring(1).toLowerCase();

        System.out.println("What is the buyer's last name:  ");

        lastInput = scan.nextLine();

        //  This ensures that the Last name is in the proper casing for output.
        //  It capitalizes the first letter and changes the rest to lower case.

        lastName = lastInput.substring(0,1).toUpperCase() + lastInput.substring(1).toLowerCase();

        System.out.println("What is the credit card type:  ");

        creditType = scan.nextLine();

        System.out.println("What is the credit card number:  ");

        creditNum = scan.nextLine();

        System.out.println("What is your vendor ID:  ");

        vendorID = scan.nextLine();

        System.out.println("How many child sweatshirts:  ");

        childNum = scan.nextInt();

        System.out.println("How many adult sweatshirts:  ");

        adultNum = scan.nextInt();


        //CALCULATION SECTION


        randomNum = rand.nextInt(500) + 500;

        confNum = "RIO2016" + firstName.charAt(0) + lastName + randomNum + "##"
                        + dateNoDash + "##" + vendorID;


        subTotal = (CHILD_COST * childNum) + (ADULT_COST * adultNum);

        tax = subTotal * SALES_TAX;

        total = subTotal + tax;


        //RECEIPT PRINTING SECTION


        System.out.println("\n\n** Sweatshirts-R-US Reciept **\n");

        System.out.println("Confirmation for " + firstName + " " + lastName);

        System.out.println("Purchased on " + date + " with " + creditType + " credit card\n");

        System.out.println("Confirmation Number: " + confNum + "\n");

        System.out.println("Adult Sweatshirts:\t" + adultNum + " @ " + dollar.format(ADULT_COST) + " each");

        System.out.println("Child Sweatshirts:\t" + childNum + " @ " + dollar.format(CHILD_COST) + " each\n");

        System.out.println("Subtotal:\t\t" + dollar.format(subTotal));

        System.out.println("Tax:\t\t\t " + dollar.format(tax));

        System.out.println("Total:\t\t\t" + dollar.format(total) + "\n");

        System.out.println("Thanks for visiting us in Rio de Janiero at the\n2016 Summer Olympics\n\n");

    }

}
