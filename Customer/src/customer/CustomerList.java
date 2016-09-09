/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;
import java.util.Scanner;
import java.io.*;


/**
 *
 * @author bill
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner fileScan;
        Scanner commaScan;
        String record;
        final int NUMATTRIBUTES = 7;
        String[] storage = new String[NUMATTRIBUTES]; 
        
        
        fileScan = new Scanner(new File("Customer.csv"));
            
        while (fileScan.hasNext()) {
                
            record = fileScan.nextLine();
            
            commaScan = new Scanner(record);
            commaScan.useDelimiter(",");
            
            for(int index = 0; index < NUMATTRIBUTES; index++){
                storage[index] = commaScan.next();
            }
            
            Customer bankCustomer = new Customer(storage[0], storage[1], storage[2], storage[3], storage[4],
                                                Float.parseFloat(storage[5]), storage[6]);
            
            
            System.out.println(bankCustomer.getFirstName());
            System.out.println(bankCustomer.getLastName());
            System.out.println(bankCustomer.getPassword());
            bankCustomer.encrypt();
            System.out.println(bankCustomer.getPassword()+"\n");
        }   
        
    }
    
}
