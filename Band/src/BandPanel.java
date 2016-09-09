/*
 * William Wyatt
 * 1/26/16
 * Java II Week 3 Assignment
 *
 * This program is a countdown timer to be shown before a concert.
 */

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

/*
 *		The BandPanel class defines all of the components and methods for the Countdown GUI. It is called by the Band Class.
 */

public class BandPanel extends JPanel
{
    private int remaining = 20, setting;
    private final int DELAY = 1000; //Timer Delay Constant
    private JButton btnStart, btnStop;
    private JLabel lblImg, lblCountdown;
    private JComboBox cmbTimer;
    private ImageIcon bandImg;
    private Timer bandTimer;
    private AudioClip song;

    public BandPanel()
    {
        URL url1 = null; //Initializes the URL variable for the music file

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Defines the Layout Manager settings

        /*
		 *		IMAGE LABEL SECTION
         */

        bandImg = new ImageIcon("prine.jpg");

        lblImg = new JLabel(bandImg);

        /*
		 *		COMBO BOX SECTION
         */

        String[] timerSettings = {"20 seconds", "1 minute", "3 minutes"};
        cmbTimer = new JComboBox<>(timerSettings);
        cmbTimer.addActionListener(new ComboListener());


		/*
		 *		TIMER LABEL SECTION
         */

        lblCountdown = new JLabel("0:" + remaining);
        lblCountdown.setFont(new Font ("Helvetica", Font.PLAIN, 48));

        /*
		 *		BUTTON SECTION
         */

        btnStart = new JButton("Start");
        btnStart.addActionListener(new StartListener());

        btnStop = new JButton("Stop");
        btnStop.addActionListener(new StopListener());

        /*
		 *		TIMER SECTION
         */

        bandTimer = new Timer(DELAY, new TimerListener());


        /*
		 *		SONG FILE SECTION
         */

        try
        {
            url1 = new URL("file", "localhost", "prine.wav");
        }
        catch (Exception exception) {}

        song = JApplet.newAudioClip(url1);

        /*
		 *		PANEL SECTION
         */

        add(lblImg);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(cmbTimer);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(Box.createVerticalGlue());
        add(lblCountdown);
        add(btnStart);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(btnStop);
        add(Box.createRigidArea(new Dimension(0, 10)));

         setPreferredSize(new Dimension(350, 400));
    }

    /*
     * 		METHOD SECTION
     */

    /*
     *		updateCounter() method sets the string of the Counter label. It takes the remaining variable and performs integer division
     *		and modulo division so that the output is displayed in minutes and seconds.
     */

    private void updateCounter()
    {
        int minutes, seconds;

        minutes = remaining / 60;
        seconds = remaining % 60;
        lblCountdown.setText(minutes + ":" + seconds);
    }

    /*
	 *		checkCombo() method looks at the selectedIndex of the combo box object and sets the remaining variable based on that Index.
	 *		All values are in seconds to facilitate the integer division that takes place inside the updateCounter method.
	 *
	 *		I created this as a method versus running it inside the combo event listener because I wanted to reset the timer correctly
	 *		every time someone hit the Start button. This way I can call it in the start event listener as well.
     */

    private void checkCombo()
    {
        setting = cmbTimer.getSelectedIndex();

        if (setting == 0)
        {
            remaining = 20;
            updateCounter();
        }
        else if (setting == 1)
        {
            remaining = 60;
            updateCounter();
        }
        else
        {
            remaining = 180;
            updateCounter();
        }

    }

    /*
     *		LISTENER CLASS SECTION
     */


    /*
     *		ComboListener is called whenever someone makes a selection in the Combo Box. It calls the checkCombo method to update the Countdown label
     *		based on the newly selected combo box item.
     */

    private class ComboListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           checkCombo();
        }
    }

    /*
     *		TimerListener is called whenever the timer object creates an event. The timer first decrements the remaining variable.
     *		It then analyzes the remaining variable. If the variable is greater than zero then it updates the counter label.
     *		Once the remaining variable hits 0, the event updates the counter label, stops the timer, and plays the song to indicate the band starting.
     */

    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            remaining -= 1;

            if (remaining == 0)
            {
                updateCounter();
                bandTimer.stop();
                song.play();
            }
            else
            {
                updateCounter();
            }

        }
    }

    /*
	 *		StartListener is called whenever someone clicks the Start Button. It first calls the checkCombo method to ensure that the combo box selection
	 *		and the counter label match, this is especially important if the Stop button was previously hit, which would make the counter labe show 0.
	 *		Then it starts the timer.
     */

    private class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            checkCombo();
            bandTimer.start();
        }
    }

    /*
	 *		StopListener is called whenever someone clicks the Stop Button. It first stops the timer, so that the music doesn't start playing.
	 *		Then it changes the remaining value to 0 and calls the updateCounter method so that the counter label shows 0.
	 *
     */

    private class StopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            bandTimer.stop();
            remaining = 0;
            updateCounter();
        }
    }

}