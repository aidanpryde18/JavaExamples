package radio;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * Created by Billy on 4/20/2016.
 */
public class RadioPanel extends JPanel
{
    private JCheckBox airControl;
    private JLabel airLabel, volumeLabel, airPenguinLabel;
    private ImageIcon airPenguinIcon;
    private JSlider volumeControl;
    private JRadioButton stationOff, stationOne, stationTwo, stationThree, stationFour, stationFive, stationSix;
    private AudioClip[] music;
    private AudioClip current;
    private Font smFont = new Font("Serif", Font.PLAIN, 8);

    public RadioPanel()
    {
        // MUSIC SECTION
        URL url1, url2, url3, url4, url5, url6;
        url1 = url2 = url3 = url4 = url5 = url6 = null;

        // Attempts to load files into an array
        try
        {
            url1 = new URL("file", "localhost", "classical.wav");
            url2 = new URL("file", "localhost", "eightiesJam.wav");
            url3 = new URL("file", "localhost", "hitchcock.wav");
            url4 = new URL("file", "localhost", "jeopardy.au");
            url5 = new URL("file", "localhost", "newAgeRythm.wav");
            url6 = new URL("file", "localhost", "westernBeat.wav");
        }
        catch (Exception e) {}

        music = new AudioClip[7];
        music[0] = null;
        music[1] = JApplet.newAudioClip (url1);
        music[2] = JApplet.newAudioClip (url2);
        music[3] = JApplet.newAudioClip (url3);
        music[4] = JApplet.newAudioClip (url4);
        music[5] = JApplet.newAudioClip (url5);
        music[6] = JApplet.newAudioClip (url6);


        // LABEL SECTION
        airLabel = new JLabel("Air Conditioning is OFF");
        volumeLabel = new JLabel("Music Volume");
        volumeLabel.setFont(smFont);
        airPenguinIcon = new ImageIcon("penguin.jpg");
        airPenguinLabel = new JLabel(airPenguinIcon);
        airPenguinLabel.setVisible(false);

        // AIR CONTROL SECTION
        airControl = new JCheckBox("A/C Control");
        AirConListener air = new AirConListener();
        airControl.addItemListener(air);

        //**********************************
        // RADIO SECTION
        //**********************************

        // Create buttons and apply labels
        stationOff = new JRadioButton("Off", true);
        stationOne = new JRadioButton("Classical");
        stationTwo = new JRadioButton("Eighties");
        stationThree = new JRadioButton("Hitchcock");
        stationFour = new JRadioButton("Jeopardy");
        stationFive = new JRadioButton("New Age");
        stationSix = new JRadioButton("Western");

        // Add them to group
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(stationOff);
        radioButtons.add(stationOne);
        radioButtons.add(stationTwo);
        radioButtons.add(stationThree);
        radioButtons.add(stationFour);
        radioButtons.add(stationFive);
        radioButtons.add(stationSix);

        // Add listener to buttons
        RadioListener change = new RadioListener();
        stationOff.addActionListener(change);
        stationOne.addActionListener(change);
        stationTwo.addActionListener(change);
        stationThree.addActionListener(change);
        stationFour.addActionListener(change);
        stationFive.addActionListener(change);
        stationSix.addActionListener(change);

        // VOLUME SECTION
        volumeControl = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
        VolumeListener volume = new VolumeListener();
        volumeControl.addChangeListener(volume);

        // PANEL SETUP SECTION
        setPreferredSize(new Dimension(325, 225));

        add(airControl);
        add(airLabel);
        add(airPenguinLabel);

        add(volumeControl);
        add(volumeLabel);

        add(stationOne);
        add(stationTwo);
        add(stationThree);
        add(stationFour);
        add(stationFive);
        add(stationSix);
        add(stationOff);

    }
    // changeStation method stops the current song, sets the new song and then loops the new song
    private void changeStation(int newStation)
    {
        if (current != null)
        {
            current.stop();
        }
        current = music[newStation];

        if (current != null)
        {
            current.loop();
        }
    }
    // Air conditioner checkbox Listener. Sets A/C to on when checked and off when unchecked
    private class AirConListener implements ItemListener
    {
        public void itemStateChanged (ItemEvent e)
        {
            if (airControl.isSelected())
            {
                airLabel.setText("Air Conditioning is ON");
                airPenguinLabel.setVisible(true);
            }
            else
            {
                airLabel.setText("Air Conditioning is OFF");
                airPenguinLabel.setVisible(false);
            }
        }
    }
    // Radio Button Listener. Calls the changeStation method and passes an int that corresponds to the
    // song for that station
    private class RadioListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            if (source == stationOff)
            {
                changeStation(0);
            }
            else if (source == stationOne)
            {
                changeStation(1);
            }
            else if (source == stationTwo)
            {
                changeStation(2);
            }
            else if (source == stationThree)
            {
                changeStation(3);
            }
            else if (source == stationFour)
            {
                changeStation(4);
            }
            else if (source == stationFive)
            {
                changeStation(5);
            }
            else if (source == stationSix)
            {
                changeStation(6);
            }
        }
    }
    // Volume Slider Listener. Changes the font size based on current slider setting
    private class VolumeListener implements ChangeListener
    {
        private int value;
        private Font medFont = new Font("Serif", Font.PLAIN, 12);
        private Font lrgFont = new Font("Serif", Font.PLAIN, 16);
        private Font xlFont = new Font("Serif", Font.PLAIN, 20);
        public void stateChanged(ChangeEvent event)
        {
            value = volumeControl.getValue();

            switch (value)
            {
                case 1:
                    volumeLabel.setFont(smFont);
                    break;
                case 2:
                    volumeLabel.setFont(medFont);
                    break;
                case 3:
                    volumeLabel.setFont(lrgFont);
                    break;
                case 4:
                    volumeLabel.setFont(xlFont);
                    break;
            }
        }
    }
}
