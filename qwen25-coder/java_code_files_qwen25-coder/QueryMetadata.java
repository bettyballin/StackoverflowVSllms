import java.sql.*;
public class QueryMetadata {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Assuming you have a method to get your database connection
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//your_oracle_db_host:port/your_database_name", "username", "password");
            
            String sql = "SELECT * FROM users WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            
            // Set the parameter if your SQL needs one
            pstmt.setInt(1, 12345);

            ResultSetMetaData metaData = pstmt.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Column Names and Types:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnTypeName = metaData.getColumnTypeName(i);
                System.out.printf("Column %d - Name: %s, Type: %s%n", i, columnName, columnTypeName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}