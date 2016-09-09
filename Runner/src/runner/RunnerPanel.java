package runner;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Billy on 4/13/2016.
 */
public class RunnerPanel extends JPanel
{
    private final int BOARD_WIDTH = 300, BOARD_HEIGHT = 400;
    int[] runnerLocation = new int[2];
    private JLabel statusLabel;


    public RunnerPanel()
    {
        statusLabel = new JLabel("Ready... Set...");
        statusLabel.setBackground(Color.cyan);
        add(statusLabel);

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT -40));

        setBackground(Color.white);
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent(page);

        page.setColor(Color.red);
        page.drawRect(0, 100, runnerLocation[0], 20);
        page.fillRect(0, 100, runnerLocation[0], 20);

        page.setColor(Color.blue);
        page.drawRect(0, 160, runnerLocation[1], 20);
        page.fillRect(0, 160, runnerLocation[1], 20);

        if(hasWinner())
        {
            statusLabel.setText(findWinner());
        }
    }

    public void startRace()
    {
        RunTask r1 = new RunTask(0);
        RunTask r2 = new RunTask(1);
        new Thread(r1).start();
        new Thread(r2).start();
        statusLabel.setText("GO!!!!!");
    }

    public boolean hasWinner()
    {
        if(runnerLocation[0] >= BOARD_WIDTH || runnerLocation[1] >= BOARD_WIDTH)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String findWinner()
    {
        if(runnerLocation[0] > runnerLocation[1])
        {
            return "Runner One Wins!!!";
        }
        else if(runnerLocation[1] > runnerLocation[0])
        {
            return "Runner Two Wins!!!";
        }
        else
        {
            return "It's A Tie!!!!";
        }
    }

    class RunTask implements Runnable
    {
        private final int INTERVAL = 100;
        private final int SPEED = 3;
        private int startLocation;
        private Random rand = new Random();
        private volatile boolean stopRequested = false;

        public RunTask(int runner)
        {
            startLocation = runner;
        }

        public void run()
        {
            try
            {
                while(!stopRequested)
                {
                    runnerLocation[startLocation] += rand.nextInt(SPEED) + 1;
                    if(hasWinner())
                    {
                        stopRequested = true;
                    }
                    repaint();
                    Thread.sleep(INTERVAL);
                }
            }
            catch (InterruptedException e) {}

        }
    }
}
