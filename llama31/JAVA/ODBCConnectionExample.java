import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;

public class ODBCConnectionExample {
  public static void main(String[] args) {
    String odbcDsn = "your_odbc_dsn";
    String username = "your_username";
    String password = "your_password";

    try {
      Connection conn = DriverManager.getConnection("jdbc:odbc:" + odbcDsn, username, password);
      // Perform queries and operations on the external database
      conn.close();
    } catch (Exception e) {
      // Handle exceptions
    }
  }
}