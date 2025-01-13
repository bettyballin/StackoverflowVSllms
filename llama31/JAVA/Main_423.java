import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main_423 {
    public static void main(String[] args) {
        // Assume you have a list of strings to filter
        List<String> data = Arrays.asList("hello", "world", "hello world");

        // Define a regular expression pattern
        Pattern pattern = Pattern.compile("hello");

        // Filter the data using the regular expression pattern
        List<String> filteredData = data.stream()
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());

        // Now, use the filtered data to construct a SQL query
        String sqlQuery = "SELECT * FROM table WHERE column IN (" + filteredData.stream()
                .map(String::valueOf)
                .map(s -> "'" + s.replace("'", "''") + "'") // add single quotes around each string and escape any existing single quotes
                .collect(Collectors.joining(", ")) + ")";

        System.out.println(sqlQuery);
    }
}