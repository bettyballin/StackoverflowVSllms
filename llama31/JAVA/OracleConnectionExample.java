import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionExample {
  public static void main(String[] args) {
    try {
      // Load the Oracle JDBC driver
      Class.forName("oracle.jdbc.OracleDriver");

      // Establish a connection to the 11g server
      Connection conn = DriverManager.getConnection(
        "jdbc:oracle:thin:@//your_server_host:your_server_port/your_service_name",
        "your_username",
        "your_password"
      );

      // Perform your database operations
      // ...

      // Close the connection
      conn.close();
    } catch (Exception e) {
      System.err.println("Error connecting to the database: " + e.getMessage());
    }
  }
}