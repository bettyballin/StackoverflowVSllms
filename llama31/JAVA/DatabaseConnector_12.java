import java.lang.String;

public class DatabaseConnector_12_12 {
    String connectionString = "jdbc:oracle:thin:@//localhost:1521/XE?oracle.jdbc.date_format=YYYY-MM-DD HH24:MI:SS";

    public static void main(String[] args) {
        DatabaseConnector_12 dbConnector = new DatabaseConnector_12();
    }
}