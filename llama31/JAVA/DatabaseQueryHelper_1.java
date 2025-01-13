import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseQueryHelper_1_1 {
    public static void main(String[] args) {
        String lastName = "Doe"; // Define the lastName variable
        String dbUrl = "jdbc:mysql://localhost:3306/mydb"; // Define the database URL
        String username = "myuser"; // Define the database username
        String password = "mypassword"; // Define the database password

        try {
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement ps = con.prepareStatement("select * from table1 where last_name like ?");
            ps.setString(1, lastName + "%");
            // You may want to execute the query and process the results here
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}