import java.lang.String;

public class DatabaseConnector {
    String url = "jdbc:sqlserver://your_host:1433;databaseName=your_database;encrypt=true;trustServerCertificate=true";

    public static void main(String[] args) {
        // Create an instance of the class to avoid the 'non-static variable cannot be referenced' error
        DatabaseConnector connector = new DatabaseConnector();
        System.out.println(connector.url); // Print the URL to verify it's working
    }
}