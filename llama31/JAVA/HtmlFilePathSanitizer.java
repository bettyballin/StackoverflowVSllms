public class HtmlFilePathSanitizer {
    public static String sanitizeHtmlFilePath(String htmlFilePath) {
        // Validate and sanitize the file path
        return htmlFilePath.replaceAll("[^a-zA-Z0-9._-]", "");
    }

    public static void main(String[] args) {
        String htmlFilePath = "/path/to/your/html/file.html";
        String sanitizedHtmlFilePath = sanitizeHtmlFilePath(htmlFilePath);
        System.out.println(sanitizedHtmlFilePath);
    }
}