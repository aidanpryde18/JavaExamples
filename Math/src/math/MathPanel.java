/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MathPanel extends JPanel 
{
    private int firstNum, secondNum, answer;
    private int difficulty = 0;
    private boolean addition = true;
    private JButton btnNext, btnCheck, btnExit;
    private JLabel lblFirstNum, lblSecondNum, lblType, lblImg;
    private JTextField txtInput;
    private JRadioButton btnAdd, btnMult;
    private JComboBox cmbDifficulty;
    private ImageIcon right, wrong;
       
    public MathPanel()
    {
        /*
        RADIO BUTTON SECTION
        */
        
        btnAdd = new JRadioButton("Addition", true);
        btnMult = new JRadioButton("Multiplication");
        ButtonGroup group = new ButtonGroup();
        group.add(btnAdd);
        group.add(btnMult);
        
        RadioListener radio = new RadioListener();
        btnAdd.addActionListener(radio);
        btnMult.addActionListener(radio);      
        
       
        
        /*
        COMBO BOX SECTION
        */       
         
        String[] options = {"Easy", "Medium", "Hard"} ;
        
        cmbDifficulty = new JComboBox<>(options);
        ComboListener combo = new ComboListener();
        cmbDifficulty.addActionListener(combo);
        
        /*
        LABEL SECTION
        */
        
        right = new ImageIcon("Images/tick.png");
        wrong = new ImageIcon("Images/DeleteRed.png");
        lblFirstNum = new JLabel("X");
        lblType = new JLabel("+");
        lblSecondNum = new JLabel("Y");
        lblImg = new JLabel();
        lblImg.setVisible(false);
        newValues();
        
        lblFirstNum.setFont(new Font ("Helvetica", Font.PLAIN, 48));
        lblType.setFont(new Font ("Helvetica", Font.PLAIN, 48));
        lblSecondNum.setFont(new Font ("Helvetica", Font.PLAIN, 48));
        
        /*
        TEXT BOX SECTION
        */
        
        txtInput = new JTextField(10);
        txtInput.addActionListener((new AnswerListener()));
        
        /*
        BUTTON SECTION
        */
        
        btnNext = new JButton("Next Question");
        btnCheck = new JButton("Check Answer");
        btnExit = new JButton("Exit");
        
        NextListener nextListener = new NextListener();
        btnNext.addActionListener(nextListener);
        
        CheckListener checkListener = new CheckListener();
        btnCheck.addActionListener(checkListener);
        
        ExitListener exitListener = new ExitListener();
        btnExit.addActionListener(exitListener);
        
        
        /*
        PANEL SECTION
        */
       
        add(btnAdd);
        add(btnMult);
        add(cmbDifficulty);
        add(lblFirstNum);
        add(lblType);
        add(lblSecondNum);
        add(lblImg);
        add(txtInput);
        add(btnCheck);
        add(btnNext);
        add(btnExit);
        
        setPreferredSize(new Dimension(275, 300));
        
        
    }
    
    /*
     * METHOD SECTION
     */
    private void newValues()
    {
        Random generator = new Random();

        if (difficulty == 0)
        {
            firstNum = generator.nextInt(10);
            lblFirstNum.setText(Integer.toString(firstNum));

            secondNum = generator.nextInt(10);
            lblSecondNum.setText(Integer.toString(secondNum));
        }
        else if (difficulty == 1)
        {
            firstNum = generator.nextInt(90) + 10;
            lblFirstNum.setText(Integer.toString(firstNum));

            secondNum = generator.nextInt(90) + 10;
            lblSecondNum.setText(Integer.toString(secondNum));
        }
        else
        {
            firstNum = generator.nextInt(900) + 100;
            lblFirstNum.setText(Integer.toString(firstNum));

            secondNum = generator.nextInt(900) + 100;
            lblSecondNum.setText(Integer.toString(secondNum));
        }
    }
    
    private void checkAnswer()
    {       
        int correctAnswer;
        if (addition)
        {
            correctAnswer = (firstNum + secondNum);
            if (answer == correctAnswer)
            {
                lblImg.setIcon(right);
            }
            else
            {
                lblImg.setIcon(wrong);
            }        
        }
        else
        {          
            correctAnswer = (firstNum * secondNum);
            if (answer == correctAnswer)
            {
                lblImg.setIcon(right);
            }
            else
            {
                lblImg.setIcon(wrong);
            }     
        }
    }
    
    private class RadioListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            
            if (source == btnAdd)
            {
                addition = true;
                lblType.setText("+");
            }
            else
            {
                addition = false;
                lblType.setText("*");
            }

            newValues();
            
        }
    
    }
    
    private class ComboListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            difficulty = cmbDifficulty.getSelectedIndex();
            newValues();
            lblImg.setVisible(false);
        }        
    }
    
    private class AnswerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
        }        
    }
    
    private class NextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            newValues();
            lblImg.setVisible(false);
            
        }        
    }
    
    private class CheckListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            answer = Integer.parseInt(txtInput.getText());
            checkAnswer();
            lblImg.setVisible(true);
           
        }        
    }
    
    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.exit(0);
        }        
    }


    
}
