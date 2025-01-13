public class Sanitizer_2 {
    public static String sanitize(String input) {
        input = input.trim();
        // mysql_real_escape_string is a PHP function, Java equivalent is String.replace()
        input = input.replace("'", "\\'").replace("\"", "\\\"").replace("\\", "\\\\");
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello 'World'!"));
    }
}