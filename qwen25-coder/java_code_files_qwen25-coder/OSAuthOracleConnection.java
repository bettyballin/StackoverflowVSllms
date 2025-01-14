import java.lang.String;
import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.SQLException;

   public class OSAuthOracleConnection {
       public static void main(String[] args) {
           String url = "jdbc:oracle:oci:@MYDBSID"; // Use your correct TNS name or connection descriptor

           try (Connection conn = DriverManager.getConnection(url)) {
               System.out.println("Connected to the Oracle database using OS authentication.");
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
