import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StandaloneRunner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Load database driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Setup connection - replace with your actual DB setup
        String url = "jdbc:mysql://localhost:3306/yourdb";
        String username = "user";
        String password = "pass";
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM some_table");
            // Process the results or perform other actions
            System.out.println("DB Connection Successful and Query Executed!");
        }
    }
}