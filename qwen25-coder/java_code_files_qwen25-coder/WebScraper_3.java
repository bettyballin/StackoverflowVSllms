import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class WebScraper_3 {

    public static void main(String[] args) {
        String url = "http://www.rideuta.com/ridingUTA/schedules/routeSchedules.aspx";
        try {
            // Fetch the HTML content
            Document document = Jsoup.connect(url).get();

            // Find all tables in the document
            Elements tables = document.select("table");

            // Assuming the first table is the one we need
            Element table = tables.get(0);
            List<String[]> rows = parseTable(table);

            // Save rows to database
            saveToDatabase(rows);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> parseTable(Element table) {
        Elements headerRow = table.select("thead tr th");
        Elements dataRows = table.select("tbody tr");

        List<String[]> rows = new ArrayList<>();
        String[] headers = new String[headerRow.size()];
        for (int i = 0; i < headerRow.size(); i++) {
            headers[i] = headerRow.get(i).text().trim();
        }
        rows.add(headers);

        for (Element row : dataRows) {
            Elements columns = row.select("td");
            String[] cols = new String[columns.size()];
            for (int i = 0; i < columns.size(); i++) {
                cols[i] = columns.get(i).text().trim();
            }
            rows.add(cols);
        }

        return rows;
    }

    private static void saveToDatabase(List<String[]> data) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uta_schedules", "username", "password")) {

            String sql = "INSERT INTO schedules (station, time) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                for (int j = 0; j < row.length - 1; j++) { // Assuming the first column are stations
                    statement.setString(1, row[0]);
                    statement.setString(2, row[j + 1]);
                    statement.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}