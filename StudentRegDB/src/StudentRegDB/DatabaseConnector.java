package StudentRegDB;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseConnector
{

    public static void main (String args[])
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar currentDate = Calendar.getInstance();
        Connection conn = null;
        PrintWriter outFile = null;
        String registrationHeaderFormat = "%-15s %-25s %-20s %-10s%n";
        String studentDataFormat = "%n%-15s %-25s %-5s%s%-12s %s%n";
        String courseDataFormat = "%-62s %s%n";
        int numStudents = 0;
        int numCourses = 0;
        int currentStudent = 0;

        try
        {

            outFile = new PrintWriter(new FileWriter("Report.txt"));

            outFile.println("Report Date: " + dateFormat.format(currentDate.getTime()));
            outFile.format("%n%25s%s%20s%n%n", " ", "Student Registration", " ");
            outFile.format(registrationHeaderFormat, "Student ID", "Student Name", "Student Major", "Courses");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentsReg","root","");

            if (conn != null)
            {
                System.out.println("We have connected to our database!");

                Statement s = conn.createStatement();

                String SQLstmt = "SELECT students.StudentID, CONCAT(students.FirstName,' ', students.LastName) AS 'Student Name',";
                SQLstmt += " students.Major, registration.CourseID";
                SQLstmt += " FROM students JOIN registration ON students.StudentID = registration.StudentID";
                SQLstmt += " ORDER BY students.StudentID;";
                System.out.println(SQLstmt);
                s.execute(SQLstmt);
                ResultSet rs = s.getResultSet();

                while (rs.next())
                {
                    if (currentStudent == Integer.parseInt(rs.getString(1)))
                    {
                        outFile.format(courseDataFormat, "", rs.getString(4));
                        numCourses++;
                    }
                    else
                    {
                        currentStudent = Integer.parseInt(rs.getString(1));
                        outFile.format(studentDataFormat, rs.getString(1), rs.getString(2), " ", rs.getString(3), " ", rs.getString(4));
                        numCourses++;
                        numStudents++;
                    }
                }

                outFile.printf("%nNumber of Students Enrolled:\t\t" + numStudents);
                outFile.printf("%nCount of Enrollment in Classes:\t\t" + numCourses);
                conn.close();
                outFile.close();
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