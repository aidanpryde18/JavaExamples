package radio;

import javax.swing.*;

public class Radio {

    public static void main(String[] args) {

        // Creates the frame, adds the radio panel and then loads the frame
        JFrame frame = new JFrame("Radio");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RadioPanel panel = new RadioPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);

    }
}
