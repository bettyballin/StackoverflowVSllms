import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example_23 {
    public static void main(String[] args) throws SQLException {
        // Initialize your database connection here
        Connection connection = java.sql.DriverManager.getConnection("jdbc:sqlite::memory:"); // For example, using SQLite in-memory database

        // Initialize your variables here
        Object x = 5; // Example value
        Object y = 10; // Example value

        String SQL = "SELECT z FROM your_table WHERE x > ?"; // Always use parameters
        String SQL2 = "SELECT z FROM your_table WHERE x <= ?";

        PreparedStatement pstmt;

        if (x != null) {
            pstmt = connection.prepareStatement(SQL);
            pstmt.setObject(1, y); // Assuming y is the value you compare against
        } else {
            pstmt = connection.prepareStatement(SQL2);
            pstmt.setObject(1, y);
        }

        // For the JOIN, you can either have a separate PreparedStatement
        // or include it in the initial SQL strings with parameters

        // Example including JOIN in the initial SQL
        String SQLWithJoin = "SELECT z FROM your_table WHERE x > ? JOIN a ON b";
        String SQL2WithJoin = "SELECT z FROM your_table WHERE x <= ? JOIN a ON b";

        // Prepare statements similarly as above
    }
}