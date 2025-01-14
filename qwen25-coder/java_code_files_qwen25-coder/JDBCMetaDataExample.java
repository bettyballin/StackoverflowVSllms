import java.lang.String;
import java.sql.*;

public class JDBCMetaDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        try (Connection conn = DriverManager.getConnection(url, "username", "password")) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet catalogs = metaData.getCatalogs();
            while (catalogs.next()) {
                System.out.println("Catalog Name: " + catalogs.getString("TABLE_CAT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}