import java.sql.*;

public class UserDAO_10_10 {
    public static void main(String[] args) throws SQLException {
        // assuming 'db' is a JDBC connection
        Connection db = DriverManager.getConnection("jdbc:sqlite:your_database.db");
        PreparedStatement ps = db.prepareStatement("SELECT * FROM users WHERE name = ?");
        ps.setString(1, "John");
        ResultSet rs = ps.executeQuery();
        // don't forget to close the resources to prevent memory leaks
        rs.close();
        ps.close();
        db.close();
    }
}