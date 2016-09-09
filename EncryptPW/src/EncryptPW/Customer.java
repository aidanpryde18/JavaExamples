package EncryptPW;

import java.util.Random;

/**
 * Created by Billy on 3/23/2016.
 */
public class Customer {
    private String ID;
    private String lastName;
    private String firstName;
    private String eMailAddress;
    private String userName;
    private float bankBalance;
    private String password;
    private boolean encrypted;
    private int shift;
    private Random randomShift = new Random();

    //	PARAMETERIZED CONSTRUCTOR

    public Customer(String customerID, String customerLastName, String customerFirstName, String customerEmailAddress,
                    String customerUserName, float customerBankBalance, String customerPassword, boolean customerEncrypted, int customerShift){
        ID = customerID;
        lastName = customerLastName;
        firstName = customerFirstName;
        eMailAddress = customerEmailAddress;
        userName = customerUserName;
        bankBalance = customerBankBalance;
        password = customerPassword;
        encrypted = customerEncrypted;
        shift = customerShift;
    }

		/*		ACCESSOR SECTION
		 *
		 *		I selected accessors for First name, last name, password and userID. I chose these because they are the accessors that the program
		 *		needs for execution. If I were planning to build a more complete version of banking software, I could see creating accessors for each
		 *		customer variable. It is common for sites to give the user a chance to see their information, so each of these would need to be included.
		 *		As you can see, password needs to be accessed by internal bank applications so it needs an accessor as well.
		 *		The only variables that I can see not needing an accessor would be the shift and encrypted variable. Even then, we might want to create a list
		 *		showing that all of the passwords have been encrypted, which would require that we access the encrypted variable, or it could be handled by
		 *		a method within the class so direct access wouldn't be needed.
		 */

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String geteMailAddress(){
        return eMailAddress;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getID(){
        return ID;
    }

    public float getBankBalance(){
        return bankBalance;
    }

    public boolean getEncrypted(){
        return encrypted;
    }

    public int getShift(){
        return shift;
    }

    public void setShift(int newShift){
        shift = newShift;
    }

    //		METHOD SECTION

    public void encrypt(){
        if (!encrypted){
            String masked = "";
            String encryption = "";

            setShift(randomShift.nextInt(5) + 1);

            for (int index = (password.length()-1); index >= 0; index--)
                masked = masked + (password.charAt(index));

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
                unmasked = unmasked + (decryption.charAt(index));

            password = unmasked;
            encrypted = false;
            setShift(0);
        }
    }

    //		MUTATOR COMMENT

    /*		When it comes to which variables need mutators, I can easily see the email, First name, last name, user name, balance and password having mutators.
     *		Each of these variables could at some point need to be changed to meet the needs of the customer.  I feel like ID should be final since it is a
     *		unique identifier for the account and not something that should be changed. Also, encrypted and shift should be protected to make sure that they
     *		are not maliciously or inadvertently changed. This could cause myriad issues with security if those were touched. I can see shift needing to be changed at
     *		some point, but I feel like that should only be done by a programmer with access to the source code and not some other part of the program.
     */

}
