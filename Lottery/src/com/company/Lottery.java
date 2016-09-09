package com.company;

import java.util.Scanner;

public class Lottery {

    public static void main(String[] args)
    {

        String userName, friendName, restaurant;
        int numFriends, lotto1, lotto2, lotto3;
        float winnings;

        //Creates an instance of the scanner object for gathering user input
        Scanner scan = new Scanner(System.in);

        //User input section. Asks user questions and stores their answers in variables
        System.out.println("Enter your name:");

        userName = scan.nextLine();

        System.out.println("Enter your friend's name:");

        friendName = scan.nextLine();

        System.out.println("Enter the name of your favorite restaurant:");

        restaurant = scan.nextLine();

        System.out.println("How many close friends do you have:");

        numFriends = scan.nextInt();

        System.out.println("Enter a number between 1-20:");

        lotto1 = scan.nextInt();

        System.out.println("Enter a number between 1-20:");

        lotto2 = scan.nextInt();

        System.out.println("Enter a number between 1-20:");

        lotto3 = scan.nextInt();

        System.out.println("How much money is in the next lottery jackpot");

        winnings = scan.nextFloat();

        System.out.println("\nThere once was a student named " + userName + ". On " + userName + "\'s birthday, " + userName
                            + " and " + numFriends + " friends went to \n" + restaurant + " to celebrate. On the way to " + restaurant
                            + ", they stopped and purchased a Pick 3 lottery ticket. The \n" + "numbers they played were:");

        System.out.println("\t \t \t" + lotto1 + "\t \t \t" + lotto2 + "\t \t \t" + lotto3);

        System.out.println("\nThe next morning, " + userName + " was amazed to see they had the winning numbers! " + userName
                            + " immediately called " + friendName + ".\n\"We won! We won!\", shouted " + userName + ", \"We won "
                            + "the lottery! We won $" + winnings + ".\"");

        System.out.println("\n" + userName + " was ecstatic and began to calculate the winnings per person. " + userName
                            + " told " + friendName + " that they each would \nreceive $" + (winnings/numFriends) + ".");

        System.out.println("\n" + userName + " and all the friends had dinner again at " + restaurant + ". " + userName
                            + " and friends decided to use their winnings to go on\na cruise and have a merry old time.\tTHE END");
    }
}
