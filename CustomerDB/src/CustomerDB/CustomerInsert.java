package CustomerDB;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class CustomerInsert {

    public static void main(String[] args) {
        Connection conn;
        Scanner inFile = null;
        String customerID, gender, firstName, middleInitial, lastName, street, city, state, zip, birthDate, ccType, ccNum, ccExp;
        int rowsAdded = 0;
        try
        {
            inFile = new Scanner(new File("Customers.csv"));
            inFile.useDelimiter(",");

            String createTableStatement = "CREATE TABLE Customers " +
                                                        "(Customer_ID VARCHAR(5), " +
                                                        "Gender CHAR(1), " +
                                                        "FName VARCHAR(15), " +
                                                        "MInitial CHAR(1), " +
                                                        "LName VARCHAR(15), " +
                                                        "Street VARCHAR(40), " +
                                                        "City VARCHAR(30), " +
                                                        "State CHAR(2), " +
                                                        "Zip CHAR(5), " +
                                                        "Birthdate CHAR(10), " +
                                                        "CCType VARCHAR(15), " +
                                                        "CCNum CHAR(16), " +
                                                        "CCExp CHAR(7), " +
                                                        "PRIMARY KEY (Customer_ID));";



            //		Connects to MySQL Database
            conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentsReg","root","");

            if (conn != null)
            {
                System.out.println("Database Connected\n");

                Statement createTable = conn.createStatement();
                createTable.execute(createTableStatement);

                System.out.println("Table Created\n");



                while(inFile.hasNext())
                {
                    customerID = inFile.next();
                    gender = inFile.next().substring(0, 1).toUpperCase();
                    firstName = inFile.next();
                    middleInitial = inFile.next();
                    lastName = inFile.next();
                    street = inFile.next();
                    city = inFile.next();
                    state = inFile.next();
                    zip = inFile.next();
                    birthDate = inFile.next();
                    ccType = inFile.next();
                    ccNum = inFile.next();
                    ccExp = inFile.nextLine().substring(1);

                    Statement insert = conn.createStatement();

                    String insertStatement = "INSERT INTO Customers " +
                            "VALUES ('" + customerID + "', '" + gender + "', '" + firstName + "', '" +
                            middleInitial + "', \"" + lastName + "\", '" + street.substring(1, street.length()-1) + "', '" + city + "', '" +
                            state + "', '" + zip + "', '" + birthDate + "', '" + ccType + "', '" +
                            ccNum + "', '" + ccExp + "');";

                    rowsAdded += insert.executeUpdate(insertStatement);
                }
            }

            conn.close();
            inFile.close();
            System.out.println(rowsAdded + " Rows Added\n");

        }
        catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        catch (Exception ex)
        {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
