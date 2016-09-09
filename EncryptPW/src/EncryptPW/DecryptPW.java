package EncryptPW;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DecryptPW {

    public static void main(String args[]) throws IOException {

        final int NUMBEROFATTRIBUTES = 9;
        final int NUMBEROFDASHES = 48;
        String[] storage = new String[NUMBEROFATTRIBUTES];
        String HeaderFormat = "%-8s | %-17s | %-17s%n";
        String encryptedPassword, decryptedPassword, currentID, dashString = "";
        boolean endOfFile = false;
        FileInputStream fstream = new FileInputStream("customer.bin");
        DataInputStream inputFile = new DataInputStream(fstream);

        for (int index = 0; index < NUMBEROFDASHES; index++)
            dashString += "-";

        System.out.println("\n\tCUSTOMER PASSWORD LIST\n");
        System.out.format(HeaderFormat, "ID", "Encrypted PW", "Decrypted PW");
        System.out.println(dashString);

        while (!endOfFile)
        {
            try
            {
                for(int index = 0; index < NUMBEROFATTRIBUTES; index++)
                {
                    switch (index)
                    {
                        case 0:
                            storage[index] = inputFile.readUTF();
                            break;
                        case 1:
                            storage[index] = inputFile.readUTF();
                            break;
                        case 2:
                            storage[index] = inputFile.readUTF();
                            break;
                        case 3:
                            storage[index] = inputFile.readUTF();
                            break;
                        case 4:
                            storage[index] = inputFile.readUTF();
                            break;
                        case 5:
                            storage[index] = Float.toString(inputFile.readFloat());
                            break;
                        case 6:
                            storage[index] = inputFile.readUTF();
                            break;
                        case 7:
                            storage[index] = Boolean.toString(inputFile.readBoolean());
                            break;
                        case 8:
                            storage[index] = Integer.toString(inputFile.readInt());
                            break;

                    }
                }

                Customer bankCustomer = new Customer(storage[0], storage[1], storage[2], storage[3], storage[4],
                        Float.parseFloat(storage[5]), storage[6], Boolean.parseBoolean(storage[7].toLowerCase()), Integer.parseInt(storage[8]));

                //		OUTPUT SECTION
                //		Once the Customer object has been created, information is printed to the console.
                //		Next, the password is encrypted with the encrypt method of the Class and that encrypted password is printed to the console.
                //		This loop continues until the file has been read through to the end.


                currentID = bankCustomer.getID();
                encryptedPassword = bankCustomer.getPassword();
                bankCustomer.decrypt();
                decryptedPassword = bankCustomer.getPassword();


                System.out.format(HeaderFormat, currentID, encryptedPassword, decryptedPassword);
                System.out.println(dashString);
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
        }
        System.out.println("\n\tFinished\n");
        inputFile.close();
        fstream.close();
    }
}
