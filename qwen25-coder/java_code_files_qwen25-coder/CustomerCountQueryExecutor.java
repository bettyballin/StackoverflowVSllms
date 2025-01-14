import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCountQueryExecutor {

    private Connection connection;

    String query = "SELECT COUNT(DISTINCT C.customer_id) as numCustomers FROM CUSTOMER C JOIN RENTS R ON C.customer_id = R.customer_id WHERE C.ST = ? AND R.mid = ?";

    public CustomerCountQueryExecutor(Connection connection) {
        this.connection = connection;
    }

    public void executeQuery(String state, int movieID) {
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, state);
            pstmt.setInt(2, movieID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int numCustomers = rs.getInt("numCustomers");
                    // Use numCustomers as needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}