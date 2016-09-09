//************************************************************************
//	CardGame.java
//
//  Purpose:
//	Review of Java classes and illustration of an array of objectgs
//
//	Creates a deck of Dalmuti cards and deals the card to the players.
//  This card game can be played with 4 - 8 players
//
//	This application does not actually play the game.
//************************************************************************


import java.util.Scanner;

public class CardGame
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);

		//-----------------------------------------------------------------------------------------------
		// Declarations and Instantiations
		//-----------------------------------------------------------------------------------------------

		DalmutiDeck newDeck = new DalmutiDeck();
		int numberOfPlayers = 0;
		int numberOfCardsInDeck = newDeck.getNumberOfCards();
		int playerIndex = 0;
		int cardIndex = 0;

		//-----------------------------------------------------------------------------------------------
		// Shuffle the card deck and input the number of players
		//-----------------------------------------------------------------------------------------------

		newDeck.shuffle();

		while(numberOfPlayers < 4 || numberOfPlayers > 8)
		{	System.out.print("Number of players for the game (enter a number between 4-8): " );
			numberOfPlayers = in.nextInt();
		}

		//-----------------------------------------------------------------------------------------------
		// Create an array which will hold the number of cards number cards each player is dealt.
		// Depending upon the number of players, every player may not have the same number of cards.
		//
		// For the value of maxCardsPerPlayer, 1 is added to accommodate integer division and truncation
		// For example, 80/3 players = 26. 26*3 = 78. Two cards need to still be dealt.  So, two players
		// will receive 27 cards.  The +1 handles the fact the some players will get  80/3 + 1 cards.
		//-----------------------------------------------------------------------------------------------

		int[] playerCardCount = new int[numberOfPlayers];

		for (int i = 0; i < numberOfPlayers; i++)
		 	playerCardCount[i] = 0;

		int maxCardsPerPlayer = numberOfCardsInDeck/numberOfPlayers + 1;

		//-----------------------------------------------------------------------------------------------
		// Create two-dimensional array to hold cards dealt to players.
		// Rows represent cards (1st card, 2nd card, etc.) and columns represent players (1st player, etc).
		//-----------------------------------------------------------------------------------------------
		DalmutiCard[][] players = new DalmutiCard[maxCardsPerPlayer][numberOfPlayers];

		//-----------------------------------------------------------------------------------------------
		// Loop to deal the cards from the deck
		//-----------------------------------------------------------------------------------------------

		for (int n = 0; n < numberOfCardsInDeck; n++)
		{	players[cardIndex][playerIndex] = new DalmutiCard(newDeck.dealOneCard().getCardRank());
			playerCardCount[playerIndex] = cardIndex;

		 	if (playerIndex < numberOfPlayers-1)
		 		playerIndex++;
		 	else
		 	{	playerIndex = 0;
		 		cardIndex++;
			}
		}

		//-----------------------------------------------------------------------------------------------
		// Loop to display each players cards.
		//-----------------------------------------------------------------------------------------------

	 	for (int i = 0; i < numberOfPlayers; i++)
		{	System.out.println("Cards for player " + (i+1) + ":");
			for (int j = 0; j <= playerCardCount[i]; j++)
			{	System.out.println("\t" + players[j][i].toString());
			}
		}


	}

}
