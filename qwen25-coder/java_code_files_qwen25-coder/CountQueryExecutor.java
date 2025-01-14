import java.lang.String;
public class CountQueryExecutor {
    String countQuery = "SELECT COUNT(*) FROM your_table WHERE your_conditions";
    {
        try (Statement stmt = connection.createStatement();
             ResultSet rsCount = stmt.executeQuery(countQuery)) {
            if (rsCount.next()) {
                int rowCount = rsCount.getInt(1);
                // Use rowCount as needed
            }
        }
    }
    public static void main(String[] args) {
    }
}