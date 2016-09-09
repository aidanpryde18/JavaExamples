/*
 * William Wyatt
 * 4/5/16
 * CIT 149 Java I
 * State Report Assignment
 *
 * This program reads from a csv file of states
 * and creates a report of state names and capitals. It also checks on state birds and flowers.
 */
package statereport;
import java.util.Scanner;
import java.io.*;

public class StateReport 
{

    public static void main(String[] args) throws IOException 
    {
        Scanner commaScan = null;
        Scanner fileScan;
        Scanner fileLengthScan;
        final int NUMBEROFATTRIBUTES = 4;
        State[] stateArray;
        String[] storage = new String[NUMBEROFATTRIBUTES];        
        int cardinalCount = 0;
        int violetCount = 0;
        int fileLength = 0;
        String currentRecord;
        String stateHeaderFormat = "%-20s %-20s%n%n";
        String stateDataFormat = "%-20s %-20s%n";
        
        // FILE LENGTH CHECK
        // This checks the file length so that the array size matches the file length
        fileLengthScan = new Scanner(new File("States.txt"));
        
        while(fileLengthScan.hasNext())
        {
            fileLengthScan.nextLine();
            fileLength++;
        }
        
        fileLengthScan.close();
        
        // CREATES THE STATE ARRAY SIZED TO FILE LENGTH FOR BUFFER OVERFLOW AND EOF ERROR PREVENTION 
        stateArray = new State[fileLength];
        
        fileScan = new Scanner(new File("States.txt"));
        
        // ARRAY GENERATION AND OBJECT CREATION
        for (int arrayIndex = 0; arrayIndex < fileLength; arrayIndex++)
        {
            currentRecord = fileScan.nextLine();

            commaScan = new Scanner(currentRecord);
            commaScan.useDelimiter(",");

            for(int attribute = 0; attribute < NUMBEROFATTRIBUTES; attribute++)
            {
                storage[attribute] = commaScan.next();
            }

            stateArray[arrayIndex] = new State(storage[0], storage[1], storage[2], storage[3]);
        }
        
        // HEADER OUTPUT
        System.out.format(stateHeaderFormat, "STATE NAME", "CAPITAL NAME");
        
        // DATA OUTPUT INCLUDES FLOWER AND BIRD CALCULATION
        for (int arrayIndex = 0; arrayIndex < fileLength; arrayIndex++)
        {
            System.out.format(stateDataFormat, stateArray[arrayIndex].getStateName(), stateArray[arrayIndex].getStateCapital());
            
            if (stateArray[arrayIndex].getStateBird().equals("Cardinal"))
            {
                cardinalCount++;
            }
            
            if (stateArray[arrayIndex].getStateFlower().toLowerCase().contains("violet"))
            {
                violetCount++;
            }
        }
        
        //Close Scanners
        commaScan.close();
        fileScan.close();
        
        // CALCULATION SUMMARY OUTPUT
        System.out.println("\nNumber of States who have Cardinal as their state bird:\t\t\t" + cardinalCount);
        System.out.println("Number of States who have some type of violet as their state flower:\t" + violetCount);
        
    }
    
}
