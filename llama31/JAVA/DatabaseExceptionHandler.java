import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.persistence.PersistenceException;
import java.sql.SQLException;

public class DatabaseExceptionHandler {
    public static void main(String[] args) {
        try {
            // Your database operation code here
        } catch (PersistenceException e) {
            if (e.getCause() instanceof SQLException) {
                SQLException sqlException = (SQLException) e.getCause();
                String message = sqlException.getMessage();
                // Assuming the error message format is something like:
                // "Duplicate entry 'value' for key 'table_name.field_name'"
                Pattern pattern = Pattern.compile("Duplicate entry '.*' for key '(.+?)\\.(.+?)'");
                Matcher matcher = pattern.matcher(message);
                if (matcher.find()) {
                    String tableName = matcher.group(1);
                    String fieldName = matcher.group(2);
                    System.out.println("Table Name: " + tableName);
                    System.out.println("Field Name: " + fieldName);
                }
            }
        }
    }
}