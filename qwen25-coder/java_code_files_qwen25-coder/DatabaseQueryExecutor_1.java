import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor_1 {
    private String getSafeTableName(String reportDate) {
        // Validate and sanitize the table name.
        // Example: Ensure it only contains alphanumeric characters and underscores.
        return reportDate.replaceAll("[^a-zA-Z0-9_]", "");
    }

    public void executeQuery(String reportDate) {
        try {
            reportDate = getSafeTableName(reportDate);

            String query1 = "SELECT plantID, edrman, plant, vaxnode FROM [" + reportDate + "]";

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(Display.DB_MERC);
            PreparedStatement st = conn.prepareStatement(query1);
            ResultSet rs = st.executeQuery();

            // Process the results...
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // You can test your code here
    }
}

class Display {
    public static final String DB_MERC = "jdbc:your_connection_string";
}