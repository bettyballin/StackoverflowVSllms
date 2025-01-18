import java.sql.*;

public class SecureDatabaseQuery {
    Connection connection;
    String searchBoxInput;

    public SecureDatabaseQuery() throws SQLException {
        String query = "SELECT * FROM table WHERE field = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, searchBoxInput); // Assuming `searchBoxInput` is the input from the user
        ResultSet rs = ps.executeQuery();
    }

    public static void main(String[] args) {
    }
}