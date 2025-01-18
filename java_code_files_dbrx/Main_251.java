import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    private static final String QUICK_SEARCH = "select * from c where NAME like ?";

    public static void main(String[] args) {
        String searchName = "%" + "example" + "%"; // replace 'YOUR_VALUE' with your value.

        try {
            Connection connection = DriverManager.getConnection("jdbc:yourdriver:yourdatabase", "username", "password"); // Obtain a Connection object from your datasource.
            PreparedStatement pstmt = connection.prepareStatement(QUICK_SEARCH);
            pstmt.setString(1, searchName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}