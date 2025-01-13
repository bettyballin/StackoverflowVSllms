import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KillSession {
  public static void main(String[] args) {
    // Load Oracle JDBC driver
    String dbUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
    String username = "your_username";
    String password = "your_password";

    try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
      // Get sid and serial# for current session
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT sid, serial# FROM V$SESSION WHERE audsid = SYS_CONTEXT('USERENV', 'SESSIONID')");
      rs.next();
      int sid = rs.getInt(1);
      int serial = rs.getInt(2);

      // Kill the session
      stmt.execute("ALTER SYSTEM KILL SESSION '" + sid + "," + serial + "'");
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}