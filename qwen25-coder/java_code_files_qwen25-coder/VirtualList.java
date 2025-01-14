import java.sql.*;
import java.util.AbstractList;
import java.util.List;

public class VirtualList extends AbstractList<ResultSet> {
    private final Connection connection;
    private final String query;
    private final int batchSize;
    private final int totalSize;

    public VirtualList(Connection connection, String query, int batchSize) throws SQLException {
        this.connection = connection;
        this.query = query;
        this.batchSize = batchSize;
        this.totalSize = getTotalCount();
    }

    @Override
    public ResultSet get(int index) {
        if (index < 0 || index >= totalSize) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        
        int pageStart = (index / batchSize) * batchSize;
        String pagedQuery = query + " LIMIT ? OFFSET ?";
        try (PreparedStatement stmt = connection.prepareStatement(pagedQuery)) {
            stmt.setInt(1, batchSize);
            stmt.setInt(2, pageStart);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return resultSet;
            } else {
                throw new IndexOutOfBoundsException("No data found at index: " + index);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int size() {
        return totalSize;
    }

    private int getTotalCount() throws SQLException {
        String countQuery = query.replace("*", "COUNT(*)");
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(countQuery)) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        // Example usage
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        String query = "SELECT * FROM CUSTOMER WHERE COUNTRY='Moldovia'";
        int batchSize = 50;

        VirtualList virtualList = new VirtualList(conn, query, batchSize);

        // Fetching data in batches
        for (int i = 0; i < Math.min(virtualList.size(), 100); i++) {
            try (ResultSet rs = virtualList.get(i)) {
                do {
                    System.out.println("Customer ID: " + rs.getInt("ID"));
                    // Process other columns as needed
                } while (rs.next());
            }
        }

        conn.close();
    }
}