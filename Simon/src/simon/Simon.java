/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon;
import javax.swing.JFrame;

/**
 *
 * @author AQS242RW
 */
public class Simon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame frame = new JFrame ("Simon Says");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       SimonPanel panel = new SimonPanel();
       frame.getContentPane().add(panel);
       
       frame.pack();
       frame.setVisible(true);
       
      
    }
    
}
