import java.lang.String;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class LargeQueryExample {
    public static void main(String[] args) throws Exception {
        Properties queries = new Properties();
        try (FileInputStream fis = new FileInputStream("queries.properties")) {
            queries.load(fis);
        }

        String getComplexDataQuery = queries.getProperty("getComplexData");

        // Assuming you have a method to get the database connection
        Connection conn = DriverManager.getConnection("jdbc:yourdb://localhost", "user", "password");

        try (PreparedStatement stmt = conn.prepareStatement(getComplexDataQuery)) {
            // Use stmt to execute your query
        }
    }
}