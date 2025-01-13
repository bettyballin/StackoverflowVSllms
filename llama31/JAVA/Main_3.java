public class Main_3 {
    public static String sanitize(String input) {
        // Java equivalent of trim()
        input = input.trim();
        
        // Java equivalent of mysql_real_escape_string() 
        // is not a direct method, you would use PreparedStatements 
        // to escape the input. Here's a simple alternative.
        input = input.replace("'", "\\'");
        input = input.replace("\"", "\\\"");
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello World!"));
    }
}