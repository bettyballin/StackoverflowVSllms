import java.lang.String;
import java.sql.*;
public class Main_31 {
    public static void main(String args[]) throws Exception{
        String url = "jdbc:odbc:Driver={YOUR_DRIVER};Database=TEST;Uid=SYSTEM;PWD=MANAGER"; // Replace with appropriate values
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection(url, "myUser", "myPassword");
    }
}