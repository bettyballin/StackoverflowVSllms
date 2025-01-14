import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessDatabaseConnector {
    public static void main(String[] args) {
        // Ensure that your ODBC Data Source is configured properly to point to your .mdb or .accdb file.
        String dbURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=//yourserver/sharename/yourdbname.accdb;";
        
        try (Connection conn = DriverManager.getConnection(dbURL)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}