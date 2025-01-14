import java.sql.*;
import java.util.*;

public class SynonymProcessor {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT synonym, word FROM your_table")) {

            Map<String, List<String>> synonymsMap = new HashMap<>();

            // Fetch all data and populate the map
            while (rs.next()) {
                String synonym = rs.getString("synonym");
                String word = rs.getString("word");

                synonymsMap.computeIfAbsent(word, k -> new ArrayList<>()).add(synonym);
            }

            // Process each word with its synonyms
            for (String word : synonymsMap.keySet()) {
                process(synonymsMap.get(word), word);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void process(List<String> synonyms, String word) {
        // Your processing logic here
        System.out.println("Word: " + word + ", Synonyms: " + synonyms);
    }
}