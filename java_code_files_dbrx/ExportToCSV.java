import org.apache.commons.csv.*;
import java.sql.*;
import java.io.*;
import java.nio.file.*;

public class ExportToCSV {
    public static void main(String[] args) {
        // Replace with your actual database connection details
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT column1, column2 FROM your_table");
            CSVPrinter printer = new CSVPrinter(
                Files.newBufferedWriter(Paths.get("output.csv")),
                CSVFormat.DEFAULT
            )
        ) {
            while (rs.next()) {
                // Write each row column by column, ordered as desired
                printer.printRecord(rs.getString(1), rs.getInt(2));
            }
        } catch (IOException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        }

        // Then use command line, Linux example:
        // sort -t ',' -k 3 -o sorted_output.csv output.csv
    }
}