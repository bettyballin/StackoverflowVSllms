import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsertExample {
    public static void main(String[] args) throws SQLException {
        // obtain a connection to your SQLite database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:your_database.db");
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO mytable (column1, column2) VALUES (?, ?)");

        int batchSize = 32768; // adjust this value as needed
        int count = 0;

        // loop through your data and add it to the batch
        for (int i = 0; i < 100000; i++) { // replace with your actual loop condition
            pstmt.setString(1, "value1-" + i); // replace with your actual value
            pstmt.setString(2, "value2-" + i); // replace with your actual value
            pstmt.addBatch();

            count++;

            if (count >= batchSize) {
                pstmt.executeBatch();
                count = 0;
            }
        }

        // execute any remaining batches
        if (count > 0) {
            pstmt.executeBatch();
        }

        pstmt.close();
        conn.close();
    }
}