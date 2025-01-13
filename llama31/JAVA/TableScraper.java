import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableScraper {
    public static void main(String[] args) {
        String url = "http://www.rideuta.com/ridingUTA/schedules/routeSchedules.aspx";
        String tableName = "bus_schedules";

        // Connect to database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
            return;
        }

        // Extract table data
        try {
            Document doc = Jsoup.connect(url).get();
            Element table = doc.select("table#your_table_id").first();
            Elements rows = table.select("tr");

            // Store data in database
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("INSERT INTO " + tableName + " (station, departure_time) VALUES (?, ?)");
                for (Element row : rows) {
                    Elements cells = row.select("td");
                    if (cells.size() >= 2) {
                        String station = cells.get(0).text();
                        String departureTime = cells.get(1).text();
                        stmt.setString(1, station);
                        stmt.setString(2, departureTime);
                        stmt.executeUpdate();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error storing data in database: " + e.getMessage());
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.err.println("Error closing database connections: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error extracting table data: " + e.getMessage());
        }
    }
}