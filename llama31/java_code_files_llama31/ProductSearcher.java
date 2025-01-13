/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSearcher {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            connection = ProductSearcher.createConnection();
            String string = "Mp3 player";
            String string2 = null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.ID, p.PRODUCT_NAME, p.COLOR, p.SALE_COUNT FROM products p JOIN (   SELECT PRODUCT_NAME, COLOR, ROW_NUMBER() OVER (PARTITION BY PRODUCT_NAME ORDER BY TOTAL_SALES DESC) AS RANK   FROM product_sales ) s ON p.PRODUCT_NAME = s.PRODUCT_NAME AND p.COLOR = s.COLOR WHERE s.RANK = 1 AND p.PRODUCT_NAME LIKE ?");
            preparedStatement.setString(1, "%" + string + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("ID"));
                System.out.println("Product Name: " + resultSet.getString("PRODUCT_NAME"));
                System.out.println("Color: " + resultSet.getString("COLOR"));
                System.out.println("Sale Count: " + resultSet.getInt("SALE_COUNT"));
            }
            if (string2 != null) {
                preparedStatement = connection.prepareStatement("SELECT p.ID, p.PRODUCT_NAME, p.COLOR, p.SALE_COUNT FROM products p WHERE p.PRODUCT_NAME LIKE ? AND (p.COLOR = ? OR ? IS NULL)");
                preparedStatement.setString(1, "%" + string + "%");
                preparedStatement.setString(2, string2);
                preparedStatement.setString(3, string2);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("ID"));
                    System.out.println("Product Name: " + resultSet.getString("PRODUCT_NAME"));
                    System.out.println("Color: " + resultSet.getString("COLOR"));
                    System.out.println("Sale Count: " + resultSet.getInt("SALE_COUNT"));
                }
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error closing connection: " + sQLException.getMessage());
                }
            }
        }
    }

    private static Connection createConnection() throws SQLException {
        return null;
    }
}
