import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Execute {
    private String baseQuery = "SELECT plantID, edrman, plant, vaxnode FROM [%s]";  // %s=date
    public Execute(String reportDate) throws SQLException {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(Display.DB_MERC);
            String query1 = String.format(baseQuery, reportDate); // Concatenating the table name into string using String.format
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);  // Execute the Query with concatenated tablename
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Display {
    public static final String DB_MERC = "jdbc:odbc:your_database"; // Replace with your database connection string
}