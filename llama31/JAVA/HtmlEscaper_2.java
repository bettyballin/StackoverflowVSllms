public class HtmlEscaper_2 {
    public static String escapeHtml(String input) {
        return input.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static void main(String[] args) {
        String userInput = "<script>alert('XSS')</script>";
        System.out.println(escapeHtml(userInput));
    }
}