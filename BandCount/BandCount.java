package BandCount;
import javax.swing.JFrame;

/**
 *
 * @author AQS242RW
 */
public class BandCount
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Concert Countdown");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BandCountPanel panel = new BandCountPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);


    }

}
