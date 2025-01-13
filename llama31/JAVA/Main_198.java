public class Main_198_198 {
    public static void main(String[] args) {
        String input = "<Hello>";
        String escaped = escapeHtml(input);
        System.out.println(escaped); // prints "&lt;Hello&gt;"
    }

    public static String escapeHtml(String input) {
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}