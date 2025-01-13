import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_575 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT word, synonym FROM table ORDER BY word");
            stmt.setFetchSize(1000); // adjust the fetch size to your liking

            ResultSet results = stmt.executeQuery();

            Map<String, List<String>> wordToSynonyms = new HashMap<>();
            while (results.next()) {
                String word = results.getString(1);
                String synonym = results.getString(2);
                wordToSynonyms.computeIfAbsent(word, k -> new ArrayList<>()).add(synonym);
            }

            // process the wordToSynonyms map
            for (Map.Entry<String, List<String>> entry : wordToSynonyms.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}