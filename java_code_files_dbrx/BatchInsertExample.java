import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatchInsertExample {

    private static final String INSERT_SQL = "INSERT INTO tbl (col1, col2) VALUES(?,?)";

    public static void main(String[] args) {
        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            conn.setAutoCommit(false); // Enable transaction support

            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);

            // Assuming we have a list of records to insert
            List<Record> records = new ArrayList<>();
            // Add records to the list (replace with actual data)
            records.add(new Record("value1_col1", "value1_col2"));
            records.add(new Record("value2_col1", "value2_col2"));
            // ... add more records as needed

            int counter = 0;
            for (Record r : records) {
                ps.setString(1, r.col1Value());
                ps.setString(2, r.col2Value());
                ps.addBatch(); // Add to batch

                counter++;
                // Execute batch insert every 32768 entries
                if (counter % 32768 == 0) {
                    ps.executeBatch();
                    conn.commit();
                }
            }

            // Execute any remaining batch operations
            ps.executeBatch();
            conn.commit();

            // Clean up resources
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Assuming a Record class with appropriate methods
    static class Record {
        private String col1;
        private String col2;

        public Record(String col1, String col2) {
            this.col1 = col1;
            this.col2 = col2;
        }

        public String col1Value() {
            return col1;
        }

        public String col2Value() {
            return col2;
        }
    }
}