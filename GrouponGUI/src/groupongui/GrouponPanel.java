/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupongui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;
/**
 *
 * @author AQS242RW
 */
public class GrouponPanel extends JPanel {
    
    private JLabel regularAmount, regularAmountOutput, couponAmount, couponAmountOutput, nameLabel, dateLabel, sessionLabel, couponLabel;
    private JTextField nameField, dateField, sessionField, couponField;
    private JButton calculateButton, clearButton;
    NumberFormat dollar = NumberFormat.getCurrencyInstance();
    
    public GrouponPanel() 
    {
        regularAmount = new JLabel("Regular Price");
        regularAmountOutput = new JLabel("");
        regularAmountOutput.setVisible(false);
        
        couponAmount = new JLabel("Price with Coupon");
        couponAmountOutput = new JLabel("");
        couponAmountOutput.setVisible(false);
        
        nameLabel = new JLabel("Customer Name");
        dateLabel = new JLabel("Purchase Date");
        sessionLabel = new JLabel("# of Sessions");
        couponLabel = new JLabel("Coupon Code");
        
        nameField = new JTextField(20);
        dateField = new JTextField(12);
        sessionField = new JTextField(5);
        couponField = new JTextField(12);
        
        
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateListener());
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearListener());
        
        
        add(nameLabel);
        add(nameField);
        add(dateLabel);
        add(dateField);
        add(sessionLabel);
        add(sessionField);
        add(couponLabel);
        add(couponField);
        add(regularAmount);
        add(regularAmountOutput);
        add(couponAmount);
        add(couponAmountOutput);
        add(calculateButton);
        add(clearButton);
        
        setPreferredSize(new Dimension(400, 300));
    }
    
    private void resetFields()
    {
        regularAmountOutput.setText("");
        couponAmountOutput.setText("");
        nameField.setText("");
        dateField.setText("");
        sessionField.setText("");
        couponField.setText("");
        nameField.requestFocus();
    }
    
    private boolean validateSession(int session)
    {
        if(session > 0 && session <= 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void validateCoupon(String coupon, int sessionNum)
    {
        final double SHORT_PRICE = 15;
        final double LONG_PRICE = 30;
        final double SHORT_DISCOUNT = .20;
        final double LONG_DISCOUNT = .25;
        double total;
        
        total = (SHORT_PRICE * sessionNum);
        regularAmountOutput.setText(dollar.format(total));

        if (coupon.equals("ShortBreak")) {
                total = ((SHORT_PRICE * (1 - SHORT_DISCOUNT)) * sessionNum);
                couponAmountOutput.setText(dollar.format(total));
        }
        else if (coupon.equals("LongBreak")) {
                total = (LONG_PRICE * sessionNum);
                regularAmountOutput.setText(dollar.format(total));
                
                total = ((LONG_PRICE * (1 - LONG_DISCOUNT)) * sessionNum);
                couponAmountOutput.setText(dollar.format(total));
        }
        else {                
                couponAmountOutput.setText(dollar.format(total));
        }
        regularAmountOutput.setVisible(true);
        couponAmountOutput.setVisible(true);
    }
    
    private class ClearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            resetFields();            
        }
    }
    
    private class CalculateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int sessionNum = Integer.parseInt(sessionField.getText());
            
            if(validateSession(sessionNum))    
            {
                validateCoupon(couponField.getText(), sessionNum);
            }
            else
            {
                JOptionPane.showInternalMessageDialog(null, "Please enter a valid number of sessions(1-10");
                sessionField.setText("");
                sessionField.requestFocus();
            }
        }
    }
}
