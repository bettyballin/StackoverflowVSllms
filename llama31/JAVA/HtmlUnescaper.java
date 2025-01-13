public class HtmlUnescaper {
    public static void main(String[] args) {
        // Assuming 'description' is the field containing the HTML content
        String description = "&lt;p&gt;This is a paragraph of text.&lt;/p&gt;"; // Example HTML content
        
        // Unescape the HTML content
        String unescapedDescription = unescapeHtml(description);
        
        System.out.println("Unescaped Description:");
        System.out.println(unescapedDescription);
    }

    private static String unescapeHtml(String html) {
        return html.replace("&lt;", "<")
                   .replace("&gt;", ">");
    }
}