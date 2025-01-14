import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class DatabaseUpdater {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourDatabase";
    private static final String USER = "yourUser";
    private static final String PASS = "yourPassword";

    public void updateOrInsertCounters(Map<String, Integer> counterMap) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO yourTable (unique_column, counter) VALUES (?, ?) " +
                         "ON DUPLICATE KEY UPDATE counter = counter + VALUES(counter)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
                    pstmt.setString(1, entry.getKey());
                    pstmt.setInt(2, entry.getValue());
                    
                    pstmt.addBatch();
                }
                
                // Execute the batch
                pstmt.executeBatch();
            }
        }
    }

    public static void main(String[] args) {
    }
}