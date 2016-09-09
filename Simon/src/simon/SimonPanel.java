/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
/**
 *
 * @author AQS242RW
 */
public class SimonPanel extends JPanel
{
    
    private JLabel redLabel, blueLabel, greenLabel, yellowLabel;
    //private ImageIcon redImage, blueImage, greenImage, yellowImage, grayImage;
    private JButton startButton, stopButton;
    private Timer simonTimer;
    private int steps = 8, pointer;
    private int[] stepArray = new int[steps]; 
    private final int DELAY = 5000;


    public SimonPanel ()
    {
        
        setLayout (new GridLayout (3,2)); 
        
        //  Image Section
        /*
        redImage = new ImageIcon("red.png");
        greenImage = new ImageIcon("green.png");
        yellowImage = new ImageIcon("yellow.png");
        blueImage = new ImageIcon("blue.png");
        grayImage = new ImageIcon("gray.png");
        */
        //  LABEL SECTION
        
        redLabel = new JLabel();
        redLabel.setSize(100, 100);
        redLabel.setBackground(Color.red);
        redLabel.setOpaque(true);
        
        greenLabel = new JLabel(); 
        greenLabel.setSize(100, 100);
        greenLabel.setBackground(Color.green);
        greenLabel.setOpaque(true);
        
        yellowLabel = new JLabel();       
        yellowLabel.setSize(100, 100);
        yellowLabel.setBackground(Color.yellow);
        yellowLabel.setOpaque(true);
        
        blueLabel = new JLabel();
        blueLabel.setSize(100, 100);
        blueLabel.setBackground(Color.blue);
        blueLabel.setOpaque(true);
        
        startButton = new JButton("Start");
        startButton.addActionListener(new StartListener());

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new StopListener());
        
        
        simonTimer = new Timer(DELAY, new TimerListener());
        
        
        //  PANEL SECTION
        
        add(redLabel);
        add(greenLabel);
        add(yellowLabel);
        add(blueLabel);
        add(startButton);
        add(stopButton);
      
        setPreferredSize(new Dimension(300, 400));
        
    }
    
    private class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Random rand = new Random();
            
            //  Fill the Array with random integers from 1 to 4
            for (int index = 0; index < steps; index++)
                stepArray[index] = (rand.nextInt(4) + 1);
        
            changeLabelGray();
            pointer = 0;
            simonTimer.start();
        }
    }
    
    private class StopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            simonTimer.stop();
            changeLabelColor();
        }
    }
    
    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            changeLabelGray();
            
            if (pointer  < 8)
            {                
                switch (stepArray[pointer])
                {
                    case 1:
                        redLabel.setBackground(Color.red);
                    case 2:
                        greenLabel.setBackground(Color.green);
                    case 3:
                        yellowLabel.setBackground(Color.yellow);
                    case 4:
                        blueLabel.setBackground(Color.blue);                
                }
                
                pointer += 1;
            }
            else
            {
                simonTimer.stop();
            }
                
            
            
        }
    }
    
    private void changeLabelColor()
    {        
        redLabel.setBackground(Color.red);
        greenLabel.setBackground(Color.green);
        yellowLabel.setBackground(Color.yellow);
        blueLabel.setBackground(Color.blue);
        
        /*
        redLabel.setIcon(redImage);
        greenLabel.setIcon(greenImage);
        yellowLabel.setIcon(yellowImage);
        blueLabel.setIcon(blueImage);
        */
    }

    private void changeLabelGray()
    {
        redLabel.setBackground(Color.gray);
        greenLabel.setBackground(Color.gray);
        yellowLabel.setBackground(Color.gray);
        blueLabel.setBackground(Color.gray);
    }
    
    /*
    if (stepArray[pointer] == 1){
                
                redLabel.setBackground(Color.red);
                }
                else if (stepArray[pointer] == 2){
                
                greenLabel.setBackground(Color.green);
                }
                else if (stepArray[pointer] == 3){
                
                yellowLabel.setBackground(Color.yellow);
                }
                else{
                
                blueLabel.setBackground(Color.blue);
                }
                pointer += 1;
    */
}
