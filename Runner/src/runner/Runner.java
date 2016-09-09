package runner;

import java.util.Random;

/**
 * Created by Billy on 4/13/2016.
 */
public class Runner implements Runnable {

    private int distance;
    private Random rand;

    public Runner()
    {
        distance = 0;
        rand = new Random();
    }

    public int getDistance()
    {
        return distance;
    }

    public void run()
    {
        distance += rand.nextInt(5) + 1;
    }

    public void start()
    {
        run();
    }
}
