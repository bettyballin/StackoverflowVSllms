import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class LogDAO {
    private static final String DB_URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public List<LogEntry> getLogs(int pageNumber, int pageSize) {
        List<LogEntry> logEntries = new ArrayList<>();
        String query = "SELECT * FROM logs ORDER BY log_time LIMIT ? OFFSET ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, pageSize);
            stmt.setInt(2, (pageNumber - 1) * pageSize);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LogEntry logEntry = new LogEntry(rs.getInt("id"), rs.getString("message"));
                logEntries.add(logEntry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logEntries;
    }

    public static void main(String[] args) {
        // For testing
    }
}

class LogEntry {
    private int id;
    private String message;

    public LogEntry(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEntry{id=" + id + ", message='" + message + "'}";
    }
}