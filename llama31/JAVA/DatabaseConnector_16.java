import java.lang.String;

public class DatabaseConnector_16_16 {
    String connectionString = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=foo1.com)(PORT=1530))(CONNECT_DATA=(SERVICE_NAME=FOO)))";

    public static void main(String[] args) {
        DatabaseConnector_16 dbConnector = new DatabaseConnector_16();
        System.out.println(dbConnector.connectionString);
    }
}