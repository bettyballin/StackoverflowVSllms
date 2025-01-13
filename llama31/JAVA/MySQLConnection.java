import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "myuser";
    String password = "mypassword";

    try {
      Connection conn = DriverManager.getConnection(url, username, password);
      System.out.println("Connected to MySQL database!");
    } catch (Exception e) {
      System.out.println("Error connecting to MySQL database: " + e.getMessage());
    }
  }
}