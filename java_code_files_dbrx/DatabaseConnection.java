import java.lang.String;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DatabaseConnection {
   private static DataSource ds = null;

   static {
      try {
         Context ctx = new InitialContext();
         ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
     } catch (NamingException e) {
       System.out.println("Error in getting DataSource."+e);
     }
   }

  public static Connection getConnection() throws SQLException{
    return ds.getConnection();
  }

	public static void main(String[] args) {
	}
}