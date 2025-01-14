import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RankNeighborQueryExecutor {
    public static void main(String[] args) {
        String sql = "WITH RankedRows AS (SELECT id, name, ROW_NUMBER() OVER (ORDER BY name) as rn FROM your_table) SELECT * FROM RankedRows WHERE rn BETWEEN (SELECT rn - 2 FROM RankedRows WHERE id = ?) AND (SELECT rn + 2 FROM RankedRows WHERE id = ?);";
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/yourdb", "user", "password");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, 47);
            stmt.setInt(2, 47);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}