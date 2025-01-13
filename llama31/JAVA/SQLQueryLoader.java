import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SQLQueryLoader {
    // Load SQL query from file
    String sqlQuery;
    public SQLQueryLoader() throws IOException {
        sqlQuery = Files.readString(Paths.get("path/to/query.sql"));
    }
    public static void main(String[] args) throws IOException {
        new SQLQueryLoader();
    }
}