import java.sql.*;

public class SQLServerReader {
    public static void main(String[] args) {
        String query = "SELECT * FROM customer";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=my_db", "user", "password")) {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            // Fetch rows in sets of 100 & process each row individually:
            while (rs.next()) { // retrieve next record for each iteration
                /*...Process the current record (rs) immediately and free up memory by removing referenced objects....*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}