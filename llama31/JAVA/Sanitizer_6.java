import java.sql.*;

public class Sanitizer_6 {
    public static String sanitize(String input) {
        // Remove leading and trailing whitespaces
        input = input.trim();

        // Note: Java's equivalent of mysql_real_escape_string is not as straightforward.
        // It's generally recommended to use PreparedStatements instead of manually escaping strings.
        // However, for the sake of equivalence, here's a basic implementation:

        // Replace backslash with double backslash
        input = input.replace("\\", "\\\\");

        // Replace single quotes with escaped single quotes
        input = input.replace("'", "\\'");

        // Replace double quotes with escaped double quotes
        input = input.replace("\"", "\\\"");

        return input;
    }

    public static void main(String[] args) {
        String input = "   Some input with 'single quotes' and \"double quotes\"   ";
        System.out.println(sanitize(input));
    }
}