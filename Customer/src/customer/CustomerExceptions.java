/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author bill
 */
public class CustomerExceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InvalidPWException {
    Scanner fileScan;
        Scanner commaScan;
        String record;
        final int NUMATTRIBUTES = 7;
        String[] storage = new String[NUMATTRIBUTES]; 
        
        InvalidPWException shortPassword = new InvalidPWException("Password is too short");
        
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
            
            
            try{
             if (storage[6].length() < 10){
                
                throw shortPassword;   
            }
            }
            catch (InvalidPWException e)
            {
            System.out.println(bankCustomer.getFirstName());
            System.out.println(bankCustomer.getLastName());
            System.out.println(bankCustomer.getUserID());
            System.out.println(bankCustomer.getPassword());
            System.out.println(shortPassword + "\n");
            }
            
            
            
            
        }   
        
    }
    
}
