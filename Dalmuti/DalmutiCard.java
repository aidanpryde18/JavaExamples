//************************************************************************
//	DalmutiCard
//
//	Represents a single Dalmuti card.  It uses an 80-element array of
//  DalmutiCard objects.
//************************************************************************

public class DalmutiCard
{
    private String cardName;
    private int cardRank;

    //***********************************************************************************
    //  Constructor
    //		The constructor tests to see whether the rank that is passed in
    //		is a valid integer between 1 and 13. If it is, the constructor
    //		calls the setCard method to set the rank of the card based on
    //		the passed integer. It then sets the cardName based on the rank
    //		integers location in the rankName array.
    //					ex. if the rank integer is 4 then it assigns cardName as "Baroness"
    //						since rankName[4] = "Baroness"
    //
    //		If the rank is not a valid integer, then the rank is assigned 0 and the
    //		name is assigned as "Unknown".
    //***********************************************************************************


    public DalmutiCard (int rank)
    {

        if (rank >= 1 && rank <= 13)
        {
            setCard(rank);
        }
        else
        {
           setCard(0);
        }

    }


    //***********************************************************************************
    // Accessors for other classes to be able to retrieve the rank and name of the
    // card that is created.
    //***********************************************************************************
    public int getCardRank()
    {
        return cardRank;
    }

    public String getCardName()
    {
        return cardName;
    }

    //***********************************************************************************
    // Mutator for other classes to be able to update the rank and name of the
    // card that is created. If the passed value is invalid, it doesn't change anything.
    //
    // This method is also used in the constructor to set the initial values
    // of cardName and cardRank.
    //***********************************************************************************

    public void setCard(int rank)
    {
        String[] rankName = {"Unknown", "Dalmuti", "Archbishop", "Earl Marshal", "Baroness", "Abbess", "Knight",
                "Seamstress", "Mason", "Cook", "Shepherdess", "Stonecutter", "Peasant", "Jester"};

        cardRank = rank;
        cardName = rankName[cardRank];
    }

    //***************************************************************************************
    //  toString Method: Passes a nicely formatted string description of the card for output
    //***************************************************************************************

    public String toString()
    {
        if (cardRank < 10) {
            return (cardRank + " - " + cardName);
        }
        else {
            return (cardRank + "- " + cardName);
        }
    }
}