import java.lang.String;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private Properties queryProps = new Properties();

    public DatabaseManager() {
        try (FileInputStream fis = new FileInputStream("queries.properties")) {
            queryProps.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load SQL properties", e);
        }
    }

    public void getUserById(Connection conn, int id) throws SQLException {
        String query = queryProps.getProperty("getUserById");
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            // Execute and process the results
        }
    }

    public static void main(String[] args) {
    }
}