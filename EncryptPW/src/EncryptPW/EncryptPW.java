package EncryptPW;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EncryptPW {

    public static void main(String[] args) throws IOException {
        Scanner fileScan;
        Scanner commaScan;
        String record;
        final int NUMBEROFATTRIBUTES = 9;
        String[] storage = new String[NUMBEROFATTRIBUTES];
        final int NUMBEROFDASHES = 48;
        String HeaderFormat = "%-8s | %-17s | %-17s%n";
        String encryptedPassword, decryptedPassword, currentID, dashString = "";

        for (int index = 0; index < NUMBEROFDASHES; index++)
            dashString += "-";

        System.out.println("\n\tCUSTOMER PASSWORD LIST\n");
        System.out.format(HeaderFormat, "ID", "Decrypted PW", "Encrypted PW");
        System.out.println(dashString);


        fileScan = new Scanner(new File("Customer.csv"));
        FileOutputStream fstream = new FileOutputStream("customer.bin");
        DataOutputStream outputFile = new DataOutputStream(fstream);

        //		FILE READ SECTION
        //		It pulls each line from the file and stores each piece of data in it's own array position.
        //		That array is then used to provide parameters to the Customer constructor.

        while (fileScan.hasNext()) {

            record = fileScan.nextLine();

            commaScan = new Scanner(record);
            commaScan.useDelimiter(",");

            for(int index = 0; index < NUMBEROFATTRIBUTES; index++){
                storage[index] = commaScan.next();
            }

            Customer bankCustomer = new Customer(storage[0], storage[1], storage[2], storage[3], storage[4],
                    Float.parseFloat(storage[5]), storage[6], Boolean.parseBoolean(storage[7].toLowerCase()), Integer.parseInt(storage[8]));

            //		OUTPUT SECTION
            //		Once the Customer object has been created, information is printed to the console.
            //		Next, the password is encrypted with the encrypt method of the Class and that encrypted password is printed to the console.
            //		This loop continues until the file has been read through to the end.

            currentID = bankCustomer.getID();
            decryptedPassword = bankCustomer.getPassword();
            bankCustomer.encrypt();
            encryptedPassword = bankCustomer.getPassword();


            System.out.format(HeaderFormat, currentID, decryptedPassword, encryptedPassword);
            System.out.println(dashString);

            outputFile.writeUTF(bankCustomer.getID());
            outputFile.writeUTF(bankCustomer.getLastName());
            outputFile.writeUTF(bankCustomer.getFirstName());
            outputFile.writeUTF(bankCustomer.geteMailAddress());
            outputFile.writeUTF(bankCustomer.getUserName());
            outputFile.writeFloat(bankCustomer.getBankBalance());
            outputFile.writeUTF(bankCustomer.getPassword());
            outputFile.writeBoolean(bankCustomer.getEncrypted());
            outputFile.writeInt(bankCustomer.getShift());
        }

        outputFile.close();
        fstream.close();

        System.out.println("\n\tCustomer.bin has been saved\n");

    }

}

