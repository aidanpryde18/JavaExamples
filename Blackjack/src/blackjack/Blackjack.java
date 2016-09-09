/*
 * William Wyatt
 * 2/29/16
 * CIT 149 Java I
 * Blackjack Assignment
 *
 * This program plays a hand of blackjack.
 */

import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Card playerCard1, playerCard2, dealerCard1, dealerCard2;
        boolean programRepeat = true; // This is set to true to ensure that at least one hand is played
        String repeatResponse;
        int playerPoints, dealerPoints;

        Scanner scan = new Scanner(System.in);

        while (programRepeat) {
        playerCard1 = new Card();
        playerCard2 = new Card();
        dealerCard1 = new Card();
        dealerCard2 = new Card();

            //  DUPLICATE DETECTION SECTION
            //  If a duplicate is detected, a new card is dealt until it is no longer a duplicate

        while (playerCard1.getSuit() == playerCard2.getSuit() && playerCard1.getFace() == playerCard2.getFace()){
            playerCard2.newCard();
        }

        while (playerCard1.getSuit() == dealerCard1.getSuit() && playerCard1.getFace() == dealerCard1.getFace()){
            dealerCard1.newCard();
        }

        while (playerCard2.getSuit() == dealerCard1.getSuit() && playerCard2.getFace() == dealerCard1.getFace()){
            dealerCard1 = new Card();
        }

        while (playerCard1.getSuit() == dealerCard2.getSuit() && playerCard1.getFace() == dealerCard2.getFace()){
            dealerCard2.newCard();
        }

        while (playerCard2.getSuit() == dealerCard2.getSuit() && playerCard2.getFace() == dealerCard2.getFace()){
            dealerCard2.newCard();
        }

        while (dealerCard1.getSuit() == dealerCard2.getSuit() && dealerCard1.getFace() == dealerCard2.getFace()){
            dealerCard2.newCard();
        }

            //  POINT CALCULATION SECTION
            //  If a hand busts(22 points), points are set to 0

        playerPoints = (playerCard1.getPoints() + playerCard2.getPoints());
        if (playerPoints == 22)
            playerPoints = 0;

        dealerPoints = (dealerCard1.getPoints() + dealerCard2.getPoints());
        if (dealerPoints == 22)
            dealerPoints = 0;

            //  GAME OUTPUT SECTION
            //  If a hand busts, it is displayed, otherwise the points are displayed
            //  Since busts are 0 points, it is an automatic loss, unless both bust, then it is a tie

        System.out.println("Your hand:\n");
        System.out.println(playerCard1.toString());
        System.out.println(playerCard2.toString());

        if (playerPoints == 0)
            System.out.println("\nPlayer Busts");
        else
            System.out.println("\nYour points: " + playerPoints);

        System.out.println("\nDealer hand:\n");
        System.out.println(dealerCard1.toString());
        System.out.println(dealerCard2.toString());

        if (dealerPoints == 0)
            System.out.println("\nDealer Busts");
        else
            System.out.println("\nDealer points: " + dealerPoints);

        if (playerPoints > dealerPoints)
            System.out.println("\nPLAYER WINS!!!");
        else if (playerPoints < dealerPoints)
            System.out.println("\nDEALER WINS");
        else
            System.out.println("\nIT'S A TIE");

        //  NEW DEAL SECTION
        //  Program asks for user input if they want to play again
        //  If the first character is a y, then the game repeats. Anything else causes the program to end.

        System.out.println("\nWould you like to play another hand?(Y or N):   ");

        repeatResponse = scan.next();

        if (repeatResponse.substring(0, 1).toUpperCase().equals("Y")) {
            programRepeat = true;
            System.out.println("\n");
        }
        else
            programRepeat = false;
        }

    }

}
