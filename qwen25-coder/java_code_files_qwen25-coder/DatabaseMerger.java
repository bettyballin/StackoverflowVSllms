import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMerger {

    private static final String ORACLE_URL = "jdbc:oracle:thin:@//ORACLE_HOST:PORT/INSTANCE";
    private static final String SQL_SERVER_URL = "jdbc:sqlserver://SQLSERVER_HOST;";
    private static final String USER_ID = "YOUR_USER";
    private static final String PASSWORD = "YOUR_PASSWORD";

    public static void main(String[] args) {
        List<String> idsFromOracle = getIdsFromOracle();
        if (!idsFromOracle.isEmpty()) {
            fetchAndProcessDataFromSQLServer(idsFromOracle);
        }
    }

    private static List<String> getIdsFromOracle() {
        List<String> ids = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(ORACLE_URL, USER_ID, PASSWORD)) {
            String query = "SELECT ID FROM YOUR_ORACLE_TABLE WHERE YOUR_CONDITIONS";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    ids.add(rs.getString("ID"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    private static void fetchAndProcessDataFromSQLServer(List<String> ids) {
        try (Connection conn = DriverManager.getConnection(SQL_SERVER_URL, USER_ID, PASSWORD)) {
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM YOUR_SQLSERVER_TABLE WHERE ID IN (");
            for (int i = 0; i < ids.size(); i++) {
                if (i > 0) queryBuilder.append(",");
                queryBuilder.append("'").append(ids.get(i)).append("'");
            }
            queryBuilder.append(")");

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(queryBuilder.toString())) {
                while (rs.next()) {
                    // Process your result set here
                    System.out.println(rs.getString("COLUMN_NAME"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}