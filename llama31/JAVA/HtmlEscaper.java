import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlEscaper {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java HtmlEscaper <sender> <text>");
            System.exit(0);
        }

        String sender = escapeHtml(args[0]);
        String text = escapeHtml(args[1]);

        System.out.println("Sender: " + sender);
        System.out.println("Text: " + text);
    }

    // Simple method to escape HTML characters
    public static String escapeHtml(String input) {
        if (input == null) {
            return null;
        }

        // This is a very basic form of HTML escaping. For full functionality,
        // consider using a library like Spring's HtmlUtils or Apache Commons.
        return input.replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&#x27;");
    }
}