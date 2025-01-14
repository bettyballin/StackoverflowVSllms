import java.lang.String;
public class HtmlEscaper {
    public static String escapeHtml(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&#x27;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "<Hello>";
        String escaped = escapeHtml(original);
        System.out.println(escaped); // Output: &lt;Hello&gt;
    }
}