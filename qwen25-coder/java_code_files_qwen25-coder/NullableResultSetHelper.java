import java.sql.ResultSet;
import java.sql.SQLException;

public class NullableResultSetHelper {
    public static void main(String[] args) {
    }

    public void processResultSet(ResultSet rs) throws SQLException {
        double d = rs.getDouble("yourColumnName"); // Use column name instead of index if preferred
        if (rs.wasNull()) {
            // Handle null value (e.g., assign a default, log, etc.)
            d = 0.0; // Example: assign a default value
        } else {
            // Proceed with the non-null double value 'd'
        }
    }
}