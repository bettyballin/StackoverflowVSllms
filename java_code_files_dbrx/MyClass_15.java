import java.sql.*;
import java.time.LocalTime;

public class MyClass {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // load the driver class
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/<db-name>", "user", "password"); // connect to DB

            String sql = "INSERT INTO <table name> (route, times) VALUES(?, ?);"; // SQL insert command
            PreparedStatement stmt = conn.prepareStatement(sql); // create a statement to prepare and execute the prepared SQL command
            int i = 1; // Route number as integer
            stmt.setInt(1, i); // Route number as integer
            java.time.LocalTime start = LocalTime.now(); // Create new date instance for current time (as example)
            stmt.setObject(2, start); // Save the date in MySQL datetime type column

            stmt.executeUpdate(); // execute the statement
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions and other error cases
        }
    }
}