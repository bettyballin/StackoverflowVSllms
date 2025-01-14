import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTableClone {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//your_host:port/service_name";
        String user = "your_user";
        String password = "your_password";
        String sourceTable = "FRED";
        String targetTable = "CLONE_OF_FRED";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "CREATE TABLE " + targetTable + " AS SELECT * FROM " + sourceTable + " WHERE 1=0";
            
            // Use DatabaseMetaData to check if the table already exists and drop it if necessary
            var metaData = conn.getMetaData();
            try (var rs = metaData.getTables(null, null, targetTable.toUpperCase(), new String[]{"TABLE"})) {
                if (rs.next()) {
                    System.out.println(targetTable + " already exists. Dropping and recreating...");
                    conn.createStatement().execute("DROP TABLE " + targetTable);
                    conn.createStatement().execute(sql);
                } else {
                    conn.createStatement().execute(sql);
                }
            }

            System.out.println("Table structure cloned successfully from " + sourceTable + " to " + targetTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}