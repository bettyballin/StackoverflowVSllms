import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.sql.BLOB;

public class Main_646 {

    public static void main(String[] args) throws SQLException {
        // assuming you have a ResultSet rs
        // Replace with your actual database connection URL, username, and password
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "your_username";
        String password = "your_password";

        // Load the Oracle JDBC driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found!");
            return;
        }

        // Establish a connection to the database
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        // Create a Statement object
        Statement stmt = conn.createStatement();

        // Execute a query to get the ResultSet
        ResultSet rs = stmt.executeQuery("SELECT field FROM your_table_name");

        if (rs.next()) {
            Blob myfile = rs.getBlob("field");
            BLOB oracleBlob = new BLOB((oracle.sql.Connection) conn, myfile);
            OutputStream os = oracleBlob.getBinaryOutputStream();
            
            // use the OutputStream as needed
            // do not forget to close it when you are done to free up resources
            // os.close();
        }

        // Close the ResultSet, Statement, and Connection to free up resources
        rs.close();
        stmt.close();
        conn.close();
    }
}