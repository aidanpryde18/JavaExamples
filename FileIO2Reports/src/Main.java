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
        String state = null, zipcode = null;
        String partTimeHeaderFormat = "%-7s | %-12s | %-12s | %-10s | %-5s%n";
        String partTimeDataFormat = "%-7s | %-12s | %-12s | %-10s | %.2f%n";
        String allStudentsHeaderFormat = "%-7s | %-12s | %-12s | %-12s | %-5s | %-7s%n";
        String allStudentsDataFormat = "%-7s | %-12s | %-12s | %-12s | %-5s | %-7s%n";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar currentDate = Calendar.getInstance();
        int numberOfClasses = 0, oneClass = 0, twoClasses = 0, threeClasses = 0, totalStudents = 0;
        double gpa = 0, totalGPA = 0, averageGPA = 0;
        Scanner fileScan = null;
        PrintWriter partTimeFile = null;
        PrintWriter allStudentsFile = null;
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
            allStudentsFile = new PrintWriter(new FileWriter("AllStudents.txt"));

            partTimeFile.println("Report Date: " + dateFormat.format(currentDate.getTime()));
            partTimeFile.format("%n%20s%s%20s%n%n", " ", "Part Time Students", " ");
            partTimeFile.format(partTimeHeaderFormat, "ID", "First Name", "Last Name", "#OfClasses", "GPA");
            partTimeFile.println("---------------------------------------------------------");

            allStudentsFile.println("Report Date: " + dateFormat.format(currentDate.getTime()));
            allStudentsFile.format("%n%30s%s%30s%n%n", " ", "All Students", " ");
            allStudentsFile.format(allStudentsHeaderFormat, "ID", "First Name", "Last Name", "City", "State", "Zip");
            allStudentsFile.println("--------------------------------------------------------------------");
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
                                gpa = fileScan.nextDouble();
                                break;
                        }
                    }
                    totalGPA += gpa;
                    totalStudents++;
                    if (numberOfClasses < 4)
                    {
                        partTimeFile.format(partTimeDataFormat, id, firstName, lastName, numberOfClasses, gpa);
                        allStudentsFile.format(allStudentsDataFormat, id, firstName, lastName, city, state, zipcode);
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
                    else
                    {
                        allStudentsFile.format(allStudentsDataFormat, id, firstName, lastName, city, state, zipcode);
                    }
                }
            }
            finally
            {
                averageGPA = totalGPA / totalStudents;

                partTimeFile.printf("%nNumber of students taking 1 class:\t" + oneClass);
                partTimeFile.printf("%nNumber of students taking 2 classes:\t" + twoClasses);
                partTimeFile.printf("%nNumber of students taking 3 classes:\t" + threeClasses);

                allStudentsFile.printf("%nTotal Number of Students:\t%d", totalStudents);
                allStudentsFile.printf("%nAverage GPA of Students:\t%.2f", averageGPA);

                System.out.println("Finished");
                if (fileScan != null)
                {
                    fileScan.close();
                }
                if (partTimeFile != null)
                {
                    partTimeFile.close();
                }
                if (allStudentsFile != null)
                {
                    allStudentsFile.close();
                }

            }

        }

    }
}
