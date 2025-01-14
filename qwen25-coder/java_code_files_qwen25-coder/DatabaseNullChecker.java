import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseNullChecker {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        double d = rs.getDouble(1);
        if (rs.wasNull()) {
            // Handle the case where the double is NULL in the database
        } else {
            // Use the non-null double value
        }
    }
}