
package GrouponDos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;

public class GrouponPanel extends JPanel {

    private JLabel regularAmount, regularAmountOutput, couponAmount, couponAmountOutput, nameLabel, dateLabel, sessionLabel, couponLabel;
    private JTextField nameField, dateField, sessionField, couponField;
    private JButton calculateButton, clearButton;
    NumberFormat dollar = NumberFormat.getCurrencyInstance();

    public GrouponPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        regularAmount = new JLabel("Regular Price");
        regularAmountOutput = new JLabel("$");

        couponAmount = new JLabel("Price with Coupon");
        couponAmountOutput = new JLabel("$");

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


        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nameLabel);
        add(nameField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(dateLabel);
        add(dateField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(sessionLabel);
        add(sessionField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(couponLabel);
        add(couponField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(regularAmount);
        add(regularAmountOutput);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(couponAmount);
        add(couponAmountOutput);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(calculateButton);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(clearButton);
        add(Box.createVerticalGlue());
        add(Box.createRigidArea(new Dimension(0, 10)));
    }

    private void resetFields()
    {
        regularAmountOutput.setText("$");
        couponAmountOutput.setText("$");
        nameField.setText("");
        dateField.setText("");
        sessionField.setText("");
        couponField.setText("");
        nameField.requestFocus();
    }

    private void isInvalidSession()
    {
        JOptionPane.showMessageDialog(getParent(),"Please enter a valid number of sessions(1-10)");
        sessionField.setText("");
        sessionField.requestFocus();
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

        switch(coupon)
        {
            case "ShortBreak":
                total = ((SHORT_PRICE * (1 - SHORT_DISCOUNT)) * sessionNum);
                couponAmountOutput.setText(dollar.format(total));
                break;

            case "LongBreak":
                total = (LONG_PRICE * sessionNum);
                regularAmountOutput.setText(dollar.format(total));

                total = ((LONG_PRICE * (1 - LONG_DISCOUNT)) * sessionNum);
                couponAmountOutput.setText(dollar.format(total));
                break;

            default:
                couponAmountOutput.setText(dollar.format(total));
                break;
        }
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
            int sessionNum;
            try
            {
                sessionNum = Integer.parseInt(sessionField.getText());

                if(sessionNum > 0 && sessionNum <= 10)
                {
                    validateCoupon(couponField.getText(), sessionNum);
                }
                else
                {
                    isInvalidSession();
                }
            }
            catch (NumberFormatException e)
            {
                isInvalidSession();
            }
        }
    }
}