import java.lang.String;
import java.sql.*;

public class ProductSearch {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/yourdatabase";
        String user = "youruser";
        String password = "yourpassword";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String searchQuery = "WITH ranked_products AS ( " +
                                 "    SELECT ID, PRODUCT_NAME, COLOR, SALE_COUNT, " +
                                 "           CASE WHEN lower(PRODUCT_NAME) = lower('mp3 player') THEN 0 ELSE 1 END as exact_match, " +
                                 "           ROW_NUMBER() OVER (PARTITION BY lower(replace(PRODUCT_NAME, ' ', '')) ORDER BY sale_count DESC) as rn " +
                                 "    FROM product_table " +
                                 "    WHERE lower(PRODUCT_NAME) LIKE lower('%mp3 player%') " +
                                 ") " +
                                 "SELECT ID, PRODUCT_NAME, COLOR, SALE_COUNT " +
                                 "FROM ranked_products " +
                                 "WHERE (exact_match = 0 OR rn = 1) " +
                                 "ORDER BY exact_match, sale_count DESC;";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(searchQuery)) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String productName = rs.getString("PRODUCT_NAME");
                    String color = rs.getString("COLOR");
                    int saleCount = rs.getInt("SALE_COUNT");

                    System.out.println("ID: " + id + ", Product Name: " + productName + ", Color: " + color + ", Sales Count: " + saleCount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}