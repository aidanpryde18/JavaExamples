package CustomerDB;

import java.sql.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Billy on 4/6/2016.
 */
public class CustomerKY
{

    public static void main(String[] args)
    {
        Connection conn;
        PrintWriter outFile = null;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar currentDate = Calendar.getInstance();

        String residentFormat = "%-12s %-25s %-20s %-10s %-15s%n";
        String titleFormat = "%n%33s%s%33s%n%n";

        int rowCount = 0;

        try
        {
            //		Connects to MySQL Database
            conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentsReg","root","");
            outFile = new PrintWriter(new FileWriter("KYReport.txt"));

            outFile.println("Report Date: " + dateFormat.format(currentDate.getTime()));
            outFile.format(titleFormat, " ", "Kentucky Residents", " ");
            outFile.format(residentFormat, "Customer ID", "Name", "City", "State", "Birth Date");


            if(conn != null)
            {
                System.out.println("We have connected to our database!"); // Diagnostic to ensure database connection is successful.

                String kySelect = "SELECT Customer_ID, FName, MInitial, LName, City, State, Birthdate " +
                                        "FROM Customers " +
                                        "WHERE State = \"KY\" " +
                                        "ORDER BY FName;";

                Statement kyStatement = conn.createStatement();

                ResultSet kyResults = kyStatement.executeQuery(kySelect);

                while (kyResults.next())
                {
                    outFile.format(residentFormat, kyResults.getString(1), (kyResults.getString(2) + " " + kyResults.getString(3) +
                            " " + kyResults.getString(4)), kyResults.getString(5), kyResults.getString(6), kyResults.getString(7));
                    rowCount++;
                }

                // Prints report summary and closes all connections
                outFile.printf("%nNumber of Kentucky Residents:\t\t" + rowCount);
                conn.close();
                outFile.close();
                System.out.println("\nReport Generated\n");

            }
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
