import java.sql.*;
import java.util.Arrays;

public class Execute {
    private String query1 = "SELECT plantID, edrman, plant, vaxnode FROM ";

    public Execute(String reportDate) {
        try {
            // Ensure reportDate is a valid table name to prevent SQL injection
            String[] validTables = {"table1", "table2"}; // list of valid table names
            if (!Arrays.asList(validTables).contains(reportDate)) {
                throw new Exception("Invalid table name");
            }

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:DB_MERC"); // replaced Display.DB_MERC with a string
            PreparedStatement st = conn.prepareStatement(query1 + "[" + reportDate + "]");
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Execute("table1");
    }
}