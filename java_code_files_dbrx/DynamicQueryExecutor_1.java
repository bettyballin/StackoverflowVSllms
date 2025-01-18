import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicQueryExecutor_1 {
    public static void main(String[] args) {
        String selectSql = "SELECT ";
        StringBuilder columnNames = new StringBuilder();

        List<String> columns = new ArrayList<String>();
        // Assuming columns is populated with some column names
        columns.add("column1");
        columns.add("column2");
        columns.add("column3");
        // Add more columns as needed

        for (int i = 0; i < columns.size(); i++) {
            if (i > 0) { // Append comma before each column name except the first
                columnNames.append(", ");
            }
            columnNames.append("?").append("#").append(i); // Using '?' for parameter placeholders and '#' to differentiate between column names in the log output
        }
        selectSql += columnNames.toString() + " FROM some_table";

        // Assuming we have a database connection
        Connection dbConnection = null;
        try {
            // Obtain a database connection (replace with your actual database URL, username, and password)
            dbConnection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            PreparedStatement stmt = dbConnection.prepareStatement(selectSql);
            for (int i = 0; i < columns.size(); i++) {
                stmt.setString(i + 1, columns.get(i)); // Index in set methods starts from 1
            }
            ResultSet rs = stmt.executeQuery();
            // Process the result set as needed
            while (rs.next()) {
                // Retrieve data from the result set
                // For example: String data = rs.getString("some_column");
            }
            rs.close();
            stmt.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}