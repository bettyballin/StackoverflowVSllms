import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StateDatabaseCache {
    private List<String> usStates;

    public void loadStates() {
        usStates = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:url", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM states")) {
            while (rs.next()) {
                usStates.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getStates() {
        return usStates;
    }

    public static void main(String[] args) {
    }
}