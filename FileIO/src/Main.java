import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        final int NUMBER_OF_COLUMNS = 8;
        String id = null, firstName = null, lastName = null, city = null;
        String state = null, zipcode = null, gpa = null;
        String format = "%-7s | %-12s | %-12s | %-12s | %-7s | %-7s | %-10s | %-5s%n";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar currentDate = Calendar.getInstance();
        int numberOfClasses = 0, oneClass = 0, twoClasses = 0, threeClasses = 0;
        Scanner fileScan = null;
        PrintWriter partTimeFile = null;
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("No File Chosen");
        }
        else
        {
            File file = chooser.getSelectedFile();
            partTimeFile = new PrintWriter(new FileWriter("PartTime.txt"));

            partTimeFile.println("Report Date: " + dateFormat.format(currentDate.getTime()));
            partTimeFile.format("%37s%s%37s%n%n", " ", "Part Time Students", " ");
            partTimeFile.format(format, "ID", "First Name", "Last Name", "City", "State", "Zip", "#OfClasses", "GPA");
            partTimeFile.println("--------------------------------------------------------------------------------------------");
            try
            {
                fileScan = new Scanner(new BufferedReader(new FileReader(file)));

                while (fileScan.hasNext())
                {
                    for(int index = 0; index < NUMBER_OF_COLUMNS; index++)
                    {
                        switch (index)
                        {
                            case 0:
                                id = fileScan.next();
                                break;
                            case 1:
                                firstName = fileScan.next();
                                break;
                            case 2:
                                lastName = fileScan.next();
                                break;
                            case 3:
                                city = fileScan.next();
                                break;
                            case 4:
                                state = fileScan.next();
                                break;
                            case 5:
                                zipcode = fileScan.next();
                                break;
                            case 6:
                                numberOfClasses = fileScan.nextInt();
                                break;
                            case 7:
                                gpa = fileScan.next();
                                break;
                        }
                    }

                    if (numberOfClasses < 4)
                    {
                        partTimeFile.format(format, id, firstName, lastName, city, state, zipcode, numberOfClasses, gpa);
                        switch (numberOfClasses)
                        {
                            case 1:
                                oneClass++;
                                break;
                            case 2:
                                twoClasses++;
                                break;
                            case 3:
                                threeClasses++;
                                break;
                        }
                    }
                }
            }
            finally
            {
                partTimeFile.printf("%nNumber of students taking 1 class:\t" + oneClass);
                partTimeFile.printf("%nNumber of students taking 2 classes:\t" + twoClasses);
                partTimeFile.printf("%nNumber of students taking 3 classes:\t" + threeClasses);

                System.out.println("Finished");
                if (fileScan != null)
                {
                    fileScan.close();
                }
                if (partTimeFile != null)
                {
                    partTimeFile.close();
                }

            }

        }

    }
}
