import java.sql.*;

public class DatabaseResultSetProcessor {
    public static void main(String[] args) throws SQLException {
        // Create a connection to the database
        Connection conn = DriverManager.getConnection("url", "user", "password");

        // Create a Statement with a small fetch size
        Statement stmt = conn.createStatement();
        stmt.setFetchSize(100);

        // Create a ResultSet that streams results
        ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

        // Process each row immediately
        while (rs.next()) {
            // Process the row
            processRow(rs);
            // Discard the row to free up memory
            // Note: clearCurrentRow() is not a standard method in ResultSet
            //       it's not necessary to call it explicitly
        }

        // Close the ResultSet, Statement, and Connection
        rs.close();
        stmt.close();
        conn.close();
    }

    public static void processRow(ResultSet rs) throws SQLException {
        // Implement your row processing logic here
        // For example:
        System.out.println(rs.getString(1));
    }
}