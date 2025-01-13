import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockRetriever {
    public static void main(String[] args) {
        // Set up database connection
        String dbUrl = "your_database_url";
        String username = "your_username";
        String password = "your_password";
        
        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            StockRetriever retriever = new StockRetriever(conn);
            // Call the desired method here
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private Connection conn;
    private float price;

    public StockRetriever(Connection conn) {
        this.conn = conn;
        this.price = 0.0f; // Initialize price
    }

    public void retrieveStocks() throws SQLException {
        String query = "begin ? := sp_get_stocks(?); end;";
        try (CallableStatement stmt = conn.prepareCall(query)) {
            // register the type of the out param - a generic type
            stmt.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            // set the in param
            stmt.setFloat(2, price);
            // execute and retrieve the result set
            stmt.execute();
            try (ResultSet rs = (ResultSet) stmt.getObject(1)) {
                // Process the result set
                while (rs.next()) {
                    // Handle the result set rows
                }
            }
        }
    }
}