import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {
    // Connecting to MySQL database using JDBC Driver & Eclipse IDE
    
    public static void main(String[] args) {
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/database?user=username&password=password");
        } catch(Exception e){ 
            System.out.println("Error in connection..."); 
        }
    }
}