import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSearcher {
    public static void main(String[] args) {
        // Create a connection object
        Connection conn = null;
        try {
            // Assuming you have a method to create a connection
            conn = createConnection();

            String searchTerm = "Mp3 player"; // replace with actual search term
            String searchColor = null; // replace with actual color, if specified

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT p.ID, p.PRODUCT_NAME, p.COLOR, p.SALE_COUNT " +
                    "FROM products p " +
                    "JOIN ( " +
                    "  SELECT PRODUCT_NAME, COLOR, ROW_NUMBER() OVER (PARTITION BY PRODUCT_NAME ORDER BY TOTAL_SALES DESC) AS RANK " +
                    "  FROM product_sales " +
                    ") s ON p.PRODUCT_NAME = s.PRODUCT_NAME AND p.COLOR = s.COLOR " +
                    "WHERE s.RANK = 1 AND p.PRODUCT_NAME LIKE ?"
            );

            pstmt.setString(1, "%" + searchTerm + "%");

            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                // Process the results
                System.out.println("ID: " + results.getInt("ID"));
                System.out.println("Product Name: " + results.getString("PRODUCT_NAME"));
                System.out.println("Color: " + results.getString("COLOR"));
                System.out.println("Sale Count: " + results.getInt("SALE_COUNT"));
            }

            // If a specific color is searched, use the second query
            if (searchColor != null) {
                pstmt = conn.prepareStatement(
                        "SELECT p.ID, p.PRODUCT_NAME, p.COLOR, p.SALE_COUNT " +
                        "FROM products p " +
                        "WHERE p.PRODUCT_NAME LIKE ? AND (p.COLOR = ? OR ? IS NULL)"
                );

                pstmt.setString(1, "%" + searchTerm + "%");
                pstmt.setString(2, searchColor);
                pstmt.setString(3, searchColor);

                results = pstmt.executeQuery();

                while (results.next()) {
                    // Process the results
                    System.out.println("ID: " + results.getInt("ID"));
                    System.out.println("Product Name: " + results.getString("PRODUCT_NAME"));
                    System.out.println("Color: " + results.getString("COLOR"));
                    System.out.println("Sale Count: " + results.getInt("SALE_COUNT"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

    // Assuming you have a method to create a connection
    private static Connection createConnection() throws SQLException {
        // Replace with your actual connection creation code
        return null;
    }
}