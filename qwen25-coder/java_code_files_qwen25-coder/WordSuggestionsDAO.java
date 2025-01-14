import java.sql.*;
import java.util.*;

public class WordSuggestionsDAO {
    private Connection connection;

    public List<String> getWordSuggestions(String partialWord) {
        String sql = "SELECT Word FROM Words WHERE Word LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, partialWord + "%");
            ResultSet rs = stmt.executeQuery();
            List<String> suggestions = new ArrayList<>();
            while (rs.next()) {
                suggestions.add(rs.getString("Word"));
            }
            return suggestions;
        } catch (SQLException e) {
            // Handle exception
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
    }
}