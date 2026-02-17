import java.util.*;
import java.sql.*;
public class StudentInsert {

    
    public static float getValidMarks(String msg, float min, float max)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println(msg);
            try{
                float marks = Float.parseFloat(sc.nextLine());
                if(marks < min || marks > max)
                {
                    System.out.println("marks must be btw "+ min + " and " + max);
                }
                else{
                    return marks;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter valid Number format");
            }
        }
    }

    public static String getValidString(String msg, int maxLen)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println(msg);
            String inp = sc.nextLine().trim();
            if(inp.isEmpty())
            {
                System.out.println("Please Enter some String");
            }
            else if(inp.length() > maxLen)
            {
                System.out.println("please enter the String in maxLength");
            }
            else
            {
                return inp;
            }
            
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String studentName = getValidString("Enter Student Name : ", 30);

        String collegeName = getValidString("Enter College Name : ", 30);

         
        float r1 = getValidMarks("Enter Round 1 marks", 0, 10);

        float r2 = getValidMarks("Enter Round 2 marks", 0, 10);

        float r3 = getValidMarks("Enter Round 3 marks", 0, 10);

        float tech = getValidMarks("Enter Technical marks", 0, 20);

        String url = "jdbc:mysql://localhost:3306/machine_test";
        String username = "root";
        String password = "root";

        String sql = "INSERT INTO student_list "
                + "(StudentName, CollegeName, Round1Marks, Round2Marks, Round3Marks, TechnicalRoundMarks) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
          
            ps.setString(1, studentName);
            ps.setString(2, collegeName);
            ps.setFloat(3, r1);
            ps.setFloat(4, r2);
            ps.setFloat(5, r3);
            ps.setFloat(6, tech);
 
            ps.executeUpdate();
            System.out.println("Student record inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } 
    }
}

 