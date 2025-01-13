import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CloneTable {
  public static void main(String[] args) {
    String oldTableName = "FRED";
    String newTableName = "FRED_CLONE";

    // Load the Oracle JDBC driver
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

      // Establish a connection to the database
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

      // Create a statement object
      Statement stmt = conn.createStatement();

      // Clone the table structure
      String sql = "CREATE TABLE " + newTableName + " AS SELECT * FROM " + oldTableName + " WHERE 1=0";
      stmt.execute(sql);

      // Close the statement and connection
      stmt.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}