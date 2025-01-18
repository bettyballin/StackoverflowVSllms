import java.lang.String;
import java.sql.*;
public class Main_314 {
    public static void main(String args[]) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
	//Change the connection URL based on your Database
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/database_name","user", "password");
 	String tableName = "table";
 	DatabaseMetaData dbmd = con.getMetaData();
	ResultSet rsTables =dbmd.getTables(null, null, tableName, null);// this will select only your table
        if (rsTables.next()) {
           System.out.println("Table Exists");
         } else {
           System.out.println("Table Doesn't exist");
         }
    }
}