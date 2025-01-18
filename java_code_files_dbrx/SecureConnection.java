import java.util.Properties;
import java.sql.*;

public class SecureConnection {
    public static void main (String[] args) {
        // Set up the login details as strings
        String url = "jdbc:sqlserver://localhost;database=TestDB";
        String user = "testUser";
        String password = "testPwd";

        try {
            // Load JDBC Driver Class
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish a secure connection to the server (SSL)
            Properties properties = new Properties();
            properties.setProperty("Encrypt", "true");
            Connection con = DriverManager.getConnection(url, properties);

            System.out.println("Successfully Connected!");
        } catch (Exception e) {
             e.printStackTrace();
       }
   }
}