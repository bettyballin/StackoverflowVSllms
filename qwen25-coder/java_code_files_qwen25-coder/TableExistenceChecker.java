import java.lang.String;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableExistenceChecker {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String user = "your_username";
        String password = "your_password";
        String tableNameToCheck = "your_table_name";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, tableNameToCheck.toUpperCase(), new String[]{"TABLE"});
            
            if (tables.next()) {
                System.out.println("Table exists.");
            } else {
                System.out.println("Table does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}