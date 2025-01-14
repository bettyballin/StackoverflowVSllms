import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class FastCSVWriter {
    public static void main(String[] args) throws IOException, SQLException {
        String fileName = "fileName.csv";
        
        try (Connection connection = getConnection(); // Assume getConnection() sets up a DB connection
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table")) {

            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
                 OutputStreamWriter writer = new OutputStreamWriter(bos)) {
                
                while (resultSet.next()) {
                    // Assuming you have a method to prepare CSV Line from resultSet
                    String csvLine = getCSVLineFromResultSet(resultSet);
                    writer.write(csvLine);
                    writer.write("\n");  // New line for each record
                }
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        // Implement your connection logic here
        return null;
    }

    private static String getCSVLineFromResultSet(ResultSet resultSet) throws SQLException {
        // Extract data from ResultSet and format it as a CSV line
        StringBuilder sb = new StringBuilder();
        sb.append(resultSet.getString("column1")).append(",");
        sb.append(resultSet.getString("column2")).append(",");
        // Add other columns as needed...
        return sb.toString();
    }
}