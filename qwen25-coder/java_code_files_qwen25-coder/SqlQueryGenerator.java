import java.lang.String;
import java.sql.*;

public class SqlQueryGenerator {
    String query = "SELECT DISTINCT City AS Keyword, Country AS Sideinfo " +
                   "FROM your_table " +
                   "WHERE CONCAT(City, ' ', Country) LIKE ? " +
                   "UNION " +
                   "SELECT DISTINCT Country AS Keyword, 'Country' AS Sideinfo " +
                   "FROM your_table " +
                   "WHERE Country LIKE ?";

    Connection connection;
    String keyword;

    {
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, "%" + keyword + "%");
        pstmt.setString(2, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();
    }

    public static void main(String[] args) {
    }
}