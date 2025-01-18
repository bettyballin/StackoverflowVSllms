import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector_2 {
    String databasePath = "//your-IP/path_to_db";
    String dbUrl = "jdbc:ucanaccess://" + databasePath; // Note IP should be replaced with actual IP of the machine and path will point to *.accdb file which you want to connect.

    public void connectDatabase() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(dbUrl, "username", "password"); // Pass username & password if your db is secured
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tablename"); // Replace with actual query you want to make.
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)); // This will print the first column, replace it with any desired column's name.
            }
        } catch (SQLException e) {
            // Handle exception as per your requirement or throw new ServiceLayerException("Database query error" + e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null && !connection.isClosed()) connection.close();
            } catch (SQLException ex) {
                // Handle exception
            }
        }
    }

    public static void main(String[] args) {
        DatabaseConnector_2 connector = new DatabaseConnector_2();
        connector.connectDatabase();
    }
}