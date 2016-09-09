/*
 * William Wyatt
 * 2/29/16
 * CIT 149 Java I
 * Blackjack Assignment
 *
 * This program plays a hand of blackjack.
 */

//************************************************************************
//	Card.java
//
//	Generates 1 card from a standard 52-card deck
//************************************************************************

import java.util.Random;

public class Card
{

	//***********************************************************************************
	//  Instance variables
	//		face:   integer representing face value (1-13)
	//		suit:	integer representing suit value (1-4)
	//	 Static constants (1 set for all card objects)
	//		SUIT_HIGH   Highest integer value to generate for a suit
	//      FACE_HIGH   Highest integer value to generate for a face
	//***********************************************************************************

	private int face, suit;
	private static final int SUIT_HIGH = 4;
	private static final int FACE_HIGH = 13;

	//***********************************************************************************
	//  Constructors
	//***********************************************************************************

	public Card()
	{
		//--------------------------------------
		//  Default constructor.  This calls the newCard( ) method to avoid duplicate code
		//--------------------------------------
		newCard();
	}

	public Card(int face, int suit)
	{
		//--------------------------------------
		//  Not used by Blackjack but included if the Card class is used by another game
		//  that needs to specifically set a Card's value
		//--------------------------------------
		this.face = face;
		this.suit = suit;
	}

	//***********************************************************************************
	//  Accessors for suit and face
	//***********************************************************************************

	public int getSuit()
		{ return suit; }

	public int getFace()
		{ return face; }


	//***********************************************************************************
	//  Mutators for suit and face
	//***********************************************************************************

	public void setFace(int face)
		{	this.face = face; }

	public void setSuit(int suit)
		{	this.suit = suit; }

	//***********************************************************************************
	//  Additional Methods
	//
	//  newCard( ) "deals" a new card"
	//  getPoints( ) returns the point value of a card
	//
	//***********************************************************************************

	public void newCard()
	{  	Random gen = new Random();
		face = gen.nextInt(FACE_HIGH) + 1;
		suit = gen.nextInt(SUIT_HIGH) + 1;
	}

	public int getPoints()
	{   int points;
		switch (face)
		{	case 2: case 3:
			case 4: case 5: case 6:
			case 7: case 8: case 9:
				points = face;
				break;
			case 1:
				points = 11;
				break;
			default:
				points = 10;
			}
		return points;
	}
	//***********************************************************************************
	//  toString Method
	//
	//  STUDENTS ARE EXPECTED TO UPDATE THIS TO DISPLAY A CARD SUCH AS:
	//       Queen of Diamonds
	//       Ace of Hearts
	//       6 of Spades
	//       etc.
	//
	//***********************************************************************************

 	public String toString()
	{
            String faceString, suitString;

            switch (face)
            {
                case 2: case 3:
                case 4: case 5: case 6:
                case 7: case 8: case 9: case 10:
                        faceString = (Integer.toString(face));
                        break;
                case 1:
                        faceString = "Ace";
                        break;
                case 11:
                        faceString = "Jack";
                        break;
                case 12:
                        faceString = "Queen";
                        break;
                case 13:
                        faceString = "King";
                        break;
                default:
                        faceString = "";
            }

            switch (suit)
            {
                case 1:
                    suitString = "Hearts";
                    break;
                case 2:
                    suitString = "Diamonds";
                    break;
                case 3:
                    suitString = "Clubs";
                    break;
                case 4:
                    suitString = "Spades";
                    break;
                default:
                    suitString = "";

            }

            return (faceString + " of " + suitString);
	}


}