//************************************************************************
//	DalmutiDeck
//
//	Represents an 80-card Dalmuti deck.  It uses an 80-element array of
//  DalmutiCard objects.
//************************************************************************

import java.util.Random;

final public class DalmutiDeck
{

	//***********************************************************************************
	//  Instance variables
	//		Constants are defined for numeric literals which will be used
	//		Notice several constants are declared as static so that only one copy of these
	//		static variables are kept in memory for all instances of a card deck in lieu of
	//		one copy for each deck.
	//
	//		deck is an array of Dalmuti Cards (80 cards)
	//		cardsNotDealt is an integer which tracks the number of cards undealt
	//***********************************************************************************
	private static final int NUMBER_OF_CARDS = 80;
	private static final int NUMBER_OF_RANKS = 13;
	private static final int NUMBER_OF_JESTERS = 2;
	private static final int JESTER_RANK = 13;
	private DalmutiCard[] deck = new DalmutiCard[NUMBER_OF_CARDS];
	private int cardsNotDealt;

	//***********************************************************************************
	//  Constructor
	//		It loads the array of the proper Dalmuti card.  For example:
	//		There are 2 Archbishop cards which have a rank of 2
	//					(next the the highest card in the deck)
	//		There are 11 Stonecutter cards which have a rank of 11
	//		There are 2 Jester cards which have a rank of 13
	//					(worst cards in the deck)
	//	NOTE:  In The Great Dalmuti card game, ranks with a lower number are better.
	//***********************************************************************************

	public DalmutiDeck()
	{
		//--------------------------------------
		//  Default constructor.
		//--------------------------------------
		int cardIndex = 0;
		cardsNotDealt = NUMBER_OF_CARDS;

		for (int i = 1; i < NUMBER_OF_RANKS; i++)
			for (int j = 1; j <= i; j++)
			{	deck[cardIndex] = new DalmutiCard(i);
				cardIndex++;
			}

		for (int i = 1; i <= NUMBER_OF_JESTERS; i++)
		{	deck[cardIndex] = new DalmutiCard(JESTER_RANK);
			cardIndex++;
		}
	}

	//***********************************************************************************
	//  Mutator to simulate shuffling the cards.  This is done by randomly swapping
	//  cards in the deck.
	//***********************************************************************************

	public void shuffle()
	{	int swapIndex;
		DalmutiCard temp;
		Random gen = new Random();

		for (int i = 0; i < NUMBER_OF_CARDS; i++)
		{
			swapIndex = gen.nextInt(NUMBER_OF_CARDS) ;
			temp = new DalmutiCard(deck[i].getCardRank());
			deck[i] = deck[swapIndex];
			deck[swapIndex] = temp;

		}
		cardsNotDealt = NUMBER_OF_CARDS;
	}

	//***********************************************************************************
	// Accessors for other classes to be able to retrieve the number of cards in the deck
	// and the number of cards yet to be dealt.
	//***********************************************************************************
	public int getNumberOfCards()
	{	return NUMBER_OF_CARDS;	}

	public int getNumberOfCardsNotDealt()
	{	return cardsNotDealt;	}


	//***********************************************************************************
	// Method to determine if there is another card to be dealt
	//***********************************************************************************

	public DalmutiCard dealOneCard()
	{	DalmutiCard nextCard = null;
		if (cardsNotDealt > 0)
		{	nextCard = deck[NUMBER_OF_CARDS-cardsNotDealt];
			cardsNotDealt--;
		}
		return nextCard;
	}
	//***********************************************************************************
	//  toString Method
	//***********************************************************************************

 	public String toString()
 	{	String deckString = "";

		for (int i = 0; i < NUMBER_OF_CARDS; i++)
			 deckString += i + " " + deck[i].toString() + "\n";

		return (deckString);
	}
}

