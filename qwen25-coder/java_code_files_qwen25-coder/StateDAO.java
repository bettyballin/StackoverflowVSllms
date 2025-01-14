import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StateDAO {
    public List<Map<String, String>> getStates(int countryId) {
        List<Map<String, String>> states = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("SELECT Abbreviation, FullName FROM States WHERE CountryID = ?")) {
            pstmt.setInt(1, countryId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Map<String, String> stateInfo = new HashMap<>();
                stateInfo.put("abbreviation", rs.getString("Abbreviation"));
                stateInfo.put("fullName", rs.getString("FullName"));
                states.add(stateInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return states;
    }
    public static void main(String[] args) {
    }
}