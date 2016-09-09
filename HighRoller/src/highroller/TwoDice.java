package highroller;

/**
 * Created by Billy on 3/7/2016.
 */
public class TwoDice
{
    private Die die1;
    private Die die2;

    public TwoDice()
    {
        die1 = new Die();
        die2 = new Die();
    }

    public int getDie1FaceValue()
    {
        return die1.getFaceValue();
    }

    public int getDie2FaceValue()
    {
        return die2.getFaceValue();
    }

    public int getTotalFaceValue()
    {
        int result = (getDie1FaceValue() + getDie2FaceValue());
        return result;
    }

    public void roll()
    {
        die1.roll();
        die2.roll();
    }

    @Override
    public String toString()
    {
        String output = ("Die 1: " + getDie1FaceValue() + "\nDie 2: " + getDie2FaceValue());
        return output;
    }
}
