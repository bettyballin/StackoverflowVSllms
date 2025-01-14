import java.lang.String;
import java.sql.*;

public class TableSchemaFetcher {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet columns = metaData.getColumns(null, null, "YOUR_TABLE_NAME", null);

            System.out.println("Schema for table: YOUR_TABLE_NAME");
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                int dataType = columns.getInt("DATA_TYPE");
                String typeName = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");

                System.out.printf("Column Name: %s, Data Type: %d (%s), Size: %d%n", 
                                    columnName, dataType, typeName, columnSize);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}