import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SqlResourceLoader {
    public static void main(String[] args) {
        try (InputStream inputStream = SqlResourceLoader.class.getResourceAsStream("my_huge_query.sql")) {
            List<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.toList());
            String hugeQuery = String.join("\n", lines); // Join the lines together with line breaks
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}