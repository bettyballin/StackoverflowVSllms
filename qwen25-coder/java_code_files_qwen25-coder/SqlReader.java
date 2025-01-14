import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SqlReader {
    public static void main(String[] args) {
        try (InputStream is = SqlReader.class.getResourceAsStream("/com/example/project/MyClass_selectUserById.sql");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder sqlBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line).append("\n");
            }
            String sqlQuery = sqlBuilder.toString();
            // You can now use sqlQuery as needed
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}