/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;
import javax.swing.JFrame;

/**
 *
 * @author AQS242RW
 */
public class Math {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame frame = new JFrame ("Math Practice");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       MathPanel panel = new MathPanel();
       frame.getContentPane().add(panel);
       
       frame.pack();
       frame.setVisible(true);
       
      
    }
    
}
