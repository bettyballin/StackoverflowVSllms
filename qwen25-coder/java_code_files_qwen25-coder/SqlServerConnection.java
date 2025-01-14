import java.lang.String;
// Java JDBC code snippet to connect to SQL Server and create a database
import java.sql.*;

public class SqlServerConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost;integratedSecurity=true;";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE DATABASE MigratedDB");
            System.out.println("Database created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}