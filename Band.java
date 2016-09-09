/*
 * William Wyatt
 * 1/26/16
 * Java II Week 3 Assignment
 *
 * This program is a countdown timer to be shown before a concert.
 */

import javax.swing.JFrame;

public class Band
    {

	/*
     * 		Creates and displays the Band GUI by creating a BandPanel object and showing it inside of the Concert Countdown frame.
     */
        public static void main(String[] args) {
            JFrame frame = new JFrame ("Concert Countdown");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            BandPanel panel = new BandPanel();
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setVisible(true);


        }

    }