package GrouponDos;
import javax.swing.JFrame;

public class GrouponDos {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Groupon");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GrouponPanel panel = new GrouponPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
