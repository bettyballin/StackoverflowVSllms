import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CRMDatabaseHelper {

    private static final String DATABASE_NAME = "CRM.db";

    private Connection connect() throws SQLException {
        // SQLite connection string
        String url = "jdbc:sqlite:" + DATABASE_NAME;
        return DriverManager.getConnection(url);
    }

    public void onCreate() {
        // Example table creation
        String sql = "CREATE TABLE IF NOT EXISTS contacts (id INTEGER PRIMARY KEY, name TEXT)";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void onUpgrade() {
        // Handle database upgrade
        String sql = "DROP TABLE IF EXISTS contacts";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            onCreate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

	public static void main(String[] args) {
        CRMDatabaseHelper dbHelper = new CRMDatabaseHelper();
        dbHelper.onCreate();
    }
}