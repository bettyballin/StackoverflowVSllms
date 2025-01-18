import java.sql.*;

public class TableRowCounter {
    String sql = "SELECT * FROM TABLE_NAME"; // Your select query
    int numberOfRows = 0;
    Connection conn;

    public TableRowCounter(Connection conn) {
        this.conn = conn;
        try {
            Statement stmt = conn.createStatement();
            try (ResultSet rsCount = stmt.executeQuery("select count(*) as count from (" + sql + ") as temp")) {
                if (rsCount.next()) {
                    numberOfRows = rsCount.getInt("count"); // Fetches the COUNT returned by query.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Provide a valid Connection object
        Connection conn = null; // placeholder for actual connection

        // Create an instance of TableRowCounter
        new TableRowCounter(conn);
    }
}