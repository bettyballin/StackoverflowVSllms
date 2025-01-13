import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDatabaseConnector_5_5 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("your_oracle_db_url");
            conn.setAutoCommit(false); // Begin transaction

            // Your SELECT statements here...

            // End transaction
            conn.commit(); // or conn.rollback();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database: " + e.getMessage());
        }
    }
}