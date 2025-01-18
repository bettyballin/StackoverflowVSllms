import java.sql.*;
import java.util.*;
import oracle.jdbc.OracleConnection;

public class MyClass {

    public List<String> findSomethingByKeyword(String keyword) throws SQLException {
        String sql = "SELECT id, name FROM table_name WHERE keyword IN (?)";

        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user", "password");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            List<String> params = new ArrayList<>(); // Add some elements here
            params.add(keyword);

            Array array = ((OracleConnection) conn).createOracleArray("VARCHAR2_TABLE", params.toArray());
            pstmt.setArray(1, array);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Process Results...
                }
            }
        }
        return null;
    }
}