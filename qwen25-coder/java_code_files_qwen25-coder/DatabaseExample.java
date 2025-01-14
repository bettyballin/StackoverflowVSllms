import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            // mysql_connect equivalent
            connection = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname", "username", "password");
            
            // mysql_query equivalent for SELECT query
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM table_name");

            // mysql_fetch_row equivalent (using ResultSet)
            while (resultSet.next()) {
                int id = resultSet.getInt(1); // retrieves first column value as integer
                String name = resultSet.getString("name"); // retrieves 'name' column value as string
                
                // process your data here
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // mysql_close equivalent (resources should be closed in reverse order of their creation)
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) {}
            try { if (statement != null) statement.close(); } catch (Exception e) {}
            try { if (connection != null) connection.close(); } catch (Exception e) {}
        }
    }
}