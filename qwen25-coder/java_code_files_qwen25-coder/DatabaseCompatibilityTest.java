import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCompatibilityTest {

    @Test
    public void testQueryAcrossDatabases() throws Exception {
        String[] dbUrls = {"jdbc:sqlserver://localhost;databaseName=MyDB",
                           "jdbc:oracle:thin:@localhost:1521:orcl",
                           "jdbc:db2://localhost:50000/mydb"};

        for (String url : dbUrls) {
            try (Connection conn = DriverManager.getConnection(url, "username", "password")) {
                assertQuery(conn);
            }
        }
    }

    private void assertQuery(Connection conn) throws SQLException {
        String query = "SELECT * FROM MyTable WHERE MyColumn = ? ORDER BY MyColumn DESC";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "SomeValue");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Expected at least one result from the query.");
        }
    }

    public static void main(String[] args) {
    }
}