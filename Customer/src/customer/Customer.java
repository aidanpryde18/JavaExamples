/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

/**
 *
 * @author bill
 */
public class Customer implements Encryptable {
    private String ID;
    private String lastName;
    private String firstName;
    private String eMailAddress;
    private String userName;
    private float bankBalance;
    private String password;
    private boolean encrypted;
    private int shift;
    
    public Customer(String customerID, String customerLastName, String customerFirstName, String customerEmailAddress,
                        String customerUserName, float customerBankBalance, String customerPassword){
        ID = customerID;
        lastName = customerLastName;
        firstName = customerFirstName;
        eMailAddress = customerEmailAddress;
        userName = customerUserName;
        bankBalance = customerBankBalance;
        password = customerPassword;
        encrypted = false;     
        shift = 4;
    }
    
    public void encrypt(){
        if (!encrypted){
            String masked = "";
            String encryption = "";
            
            for (int index = (password.length()-1); index >= 0; index--)
                masked = masked + (char)(password.charAt(index));
                        
            for (int index=0; index < masked.length(); index++)
                encryption = encryption + (char)(masked.charAt(index)+shift);
            
            password = encryption;
            encrypted = true;
        }
    }
    
    public void decrypt() {
        if (encrypted){
            String decryption = "";
            String unmasked = "";
            
            for (int index=0; index < password.length(); index++)
                decryption = decryption + (char)(password.charAt(index)-shift);
                        
            for (int index = (decryption.length()-1); index >= 0; index--)
                unmasked = unmasked + (char)(decryption.charAt(index));
            
            password = unmasked;
            encrypted = false;
        }
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getUserID(){
        return ID;
    }
    
}
