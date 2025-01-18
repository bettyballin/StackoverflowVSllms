import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class DatabaseRegexExample {
    public static void main(String[] args) {
        String regex = "your_regex";
        Connection connection = null; // obtain a Connection object;

        try {
            // Assume we have a connection
            DatabaseMetaData metadata = connection.getMetaData();
            String dbName = metadata.getDatabaseProductName().toLowerCase();
            boolean matches = false;
            if (dbName.contains("oracle")) {
                String sqlOracle = "SELECT * FROM your_table WHERE REGEXP_LIKE(column, ?)";
                try (PreparedStatement ps = connection.prepareStatement(sqlOracle)) {
                    ps.setString(1, regex);
                    ResultSet rs = ps.executeQuery();
                    // process result set here and check for matches...
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (dbName.contains("mysql")) {
                String sqlMysql = "SELECT * FROM your_table WHERE column RLIKE ?";
                try (PreparedStatement ps = connection.prepareStatement(sqlMysql)) {
                    // escape regex for MySQL compliance, e.g. replace \ with \\ or use QuoteMeta() if necessary
                    String escapedRegex = Pattern.quote(regex);
                    ps.setString(1, "(" + escapedRegex + ")");  // enclose in parentheses to comply with RLIKE operator's syntax (optional)
                    ResultSet rs = ps.executeQuery();
                    // process result set here and check for matches...
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}