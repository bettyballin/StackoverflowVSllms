import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:<DB>://";
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM table WHERE a = ? AND b > ?");
            ps.setInt(1, 1234567890); // bind first parameter to input value. Here we use an integer as example.
            ps.setLong(2, 1234567890L); // bind second parameter to another input value. Here it's a long integer value.
            ResultSet result = ps.executeQuery(); // execute the whole thing with safer inputs!
            // Process result if needed
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}