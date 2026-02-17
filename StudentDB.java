import java.sql.*;

// java -cp ".;lib/mysql-connector-j-9.6.0.jar" StudentInsert.java

public class StudentDB {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/machine_test";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Database connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
