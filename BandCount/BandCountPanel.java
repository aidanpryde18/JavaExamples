package BandCount;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class BandCountPanel extends JPanel
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

    public BandCountPanel()
    {



    }
}